package br.sc.senac.budgetech.backend.service.order;

import br.sc.senac.budgetech.backend.dto.order.OrderCreateDTO;
import br.sc.senac.budgetech.backend.dto.order.OrderDTO;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.budgetech.backend.exception.order.OrderInvalidException;
import br.sc.senac.budgetech.backend.exception.order.OrderNotFoundException;
import br.sc.senac.budgetech.backend.mapper.order.OrderMapper;
import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.model.order.Order;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderListProjectionW12;
import br.sc.senac.budgetech.backend.projection.order.OrderProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderWithFurnitureProjectionC13andW13;
import br.sc.senac.budgetech.backend.repository.furniture.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private FurnitureRepository furnitureRepository;
    private OrderMapper orderMapper;

    public OrderDTO save(OrderCreateDTO orderCreateDTO) {

        Order order = orderMapper.toEntity(orderCreateDTO);

        if (orderCreateDTO.priceOrder() < 0)
            throw new OrderInvalidException("Price " + orderCreateDTO.priceOrder() + " is invalid");

        order.setInitialDate(LocalDate.now());
        if (!order.getInitialDate().isBefore(orderCreateDTO.finalDate()))
            throw new OrderNotFoundException("Invalid Date " + orderCreateDTO.finalDate());

        for (Long idFurniture : orderCreateDTO.idFurnitures()) {
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new OrderNotFoundException("Furniture " + idFurniture + " was not found"));
            order.getFurnitures().add(furniture);
        }

        Order orderSaved = orderRepository.save(order);
        return orderMapper.toDTO(orderSaved);
    }

    public void update(OrderCreateDTO orderCreateDTO, Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));

        if (orderCreateDTO.priceOrder() < 0)
            throw new OrderInvalidException("Price " + orderCreateDTO.priceOrder() + " is invalid");

        for (Long idFurniture : orderCreateDTO.idFurnitures()) {
            order.setFurnitures(new ArrayList<>());
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new OrderNotFoundException("Order " + idFurniture + " was not found"));
            order.getFurnitures().add(furniture);
        }

        if (!order.getInitialDate().isBefore(orderCreateDTO.finalDate()))
            throw new OrderNotFoundException("Invalid Date " + orderCreateDTO.finalDate());

        order.setStatus(orderCreateDTO.status());
        order.setPayment(orderCreateDTO.payment());
        order.setFinalDate(orderCreateDTO.finalDate());
        order.setPriceOrder(orderCreateDTO.priceOrder());
        orderRepository.save(order);
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id))
            throw new OrderNotFoundException("Order " + id + " was not found");
        orderRepository.deleteById(id);
    }

    public OrderProjection findById(Long id) {
        return orderRepository.findOrderById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    }

    public List<OrderProjection> findByInitialDate(LocalDate initialDate) {
        List<OrderProjection> order = orderRepository.findOrderByInitialDate(initialDate);
        if(order.isEmpty())
            throw new OrderNotFoundException("Order " + initialDate + " was not found");
        return order;
    }

    public List<OrderWithFurnitureProjectionC13andW13> findOrderWithTwoFurniture18By() {
        List<OrderWithFurnitureProjectionC13andW13> order = orderRepository.findOrderProjection18By();
        if(order.isEmpty())
            throw new OrderNotFoundException("Order was not found");
        return order;
    }

    public List<FurnitureProjection> findListByPriceFurniture(Double priceFurniture) {
        List<FurnitureProjection> furniture = furnitureRepository.findFurnitureListByPriceFurniture(priceFurniture);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Furniture " + priceFurniture + " was not found");
        return furniture;
    }

    public List<OrderListProjectionW12> findListBy() {
        List<OrderListProjectionW12> order = orderRepository.findOrderListBy();
        if (order.isEmpty())
            throw new OrderNotFoundException("Order was not found");
        return order;
    }

    public Page<OrderListProjectionW12> findWithPaginationAndSortingById(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "id");
        return orderRepository.findOrderListW12By(pageable);
    }
}
