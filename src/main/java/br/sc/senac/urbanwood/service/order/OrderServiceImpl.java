package br.sc.senac.urbanwood.service.order;

import br.sc.senac.urbanwood.dto.order.OrderCreateDTO;
import br.sc.senac.urbanwood.dto.order.OrderDTO;
import br.sc.senac.urbanwood.exception.order.OrderInvalidException;
import br.sc.senac.urbanwood.exception.order.OrderNotFoundException;
import br.sc.senac.urbanwood.mapper.order.OrderMapper;
import br.sc.senac.urbanwood.model.furniture.Furniture;
import br.sc.senac.urbanwood.model.order.Order;
import br.sc.senac.urbanwood.projection.order.OrderProjection;
import br.sc.senac.urbanwood.projection.order.screen.OrderProjectionW12;
import br.sc.senac.urbanwood.projection.order.screen.OrderProjectionW13;
import br.sc.senac.urbanwood.repository.furniture.FurnitureRepository;
import br.sc.senac.urbanwood.repository.order.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final FurnitureRepository furnitureRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, FurnitureRepository furnitureRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.furnitureRepository = furnitureRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDTO save(OrderCreateDTO orderCreateDTO) {

        Order order = orderMapper.toEntity(orderCreateDTO);

        if (orderCreateDTO.priceOrder() <= 0)
            throw new OrderInvalidException("Price " + orderCreateDTO.priceOrder() + " is invalid");

        order.setInitialDate(LocalDate.now());
        if (!order.getInitialDate().isBefore(orderCreateDTO.finalDate()))
            throw new OrderInvalidException("Invalid Date " + orderCreateDTO.finalDate());

        for (Long idFurniture : orderCreateDTO.idFurnitures()) {
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new OrderNotFoundException("Furniture " + idFurniture + " was not found"));
            order.getFurniture().add(furniture);
        }

        Order orderSaved = orderRepository.save(order);
        return orderMapper.toDTO(orderSaved);
    }

    public void update(OrderCreateDTO orderCreateDTO, Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));

        if (orderCreateDTO.priceOrder() < 0)
            throw new OrderInvalidException("Price " + orderCreateDTO.priceOrder() + " is invalid");

        if (!order.getInitialDate().isBefore(orderCreateDTO.finalDate()))
            throw new OrderNotFoundException("Invalid Date " + orderCreateDTO.finalDate());

        for (Long idFurniture : orderCreateDTO.idFurnitures()) {
            order.setFurnitures(new ArrayList<>());
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new OrderNotFoundException("Order " + idFurniture + " was not found"));
            order.getFurniture().add(furniture);
        }

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

        if (order.isEmpty())
            throw new OrderNotFoundException("Order " + initialDate + " was not found");
        return order;
    }

    //Screen

    public Page<OrderProjectionW12> findW12OrderByInitialDate(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "initialDate" );
        return orderRepository.findOrderW12OrderByInitialDate(pageable);
    }

    public OrderProjectionW13 findW13ById(Long id) {
        return orderRepository.findOrderW13ById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    }
}
