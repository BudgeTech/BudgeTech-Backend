package br.sc.senac.budgetech.backend.service.order;

import br.sc.senac.budgetech.backend.dto.order.OrderCreateDTO;
import br.sc.senac.budgetech.backend.dto.order.OrderDTO;
import br.sc.senac.budgetech.backend.exception.order.OrderInvalidException;
import br.sc.senac.budgetech.backend.exception.order.OrderNotFoundException;
import br.sc.senac.budgetech.backend.mapper.order.OrderMapper;
import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.model.order.Order;
import br.sc.senac.budgetech.backend.projection.order.*;
import br.sc.senac.budgetech.backend.repository.furniture.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.order.OrderRepository;
import lombok.AllArgsConstructor;
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
        if(!order.getInitialDate().isBefore(orderCreateDTO.finalDate())) throw new OrderNotFoundException("Invalid Date " + orderCreateDTO.finalDate());

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

        if(!order.getInitialDate().isBefore(orderCreateDTO.finalDate())) throw new OrderNotFoundException("Invalid Date " + orderCreateDTO.finalDate());

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

    public OrderProjection findByInitialDate(LocalDate initialDate) {
        return orderRepository.findOrderByInitialDate(initialDate)
                .orElseThrow(() -> new OrderNotFoundException("Order " + initialDate + " was not found"));
    }

    public OrderProfileProjection findProfileById(Long id) {
        return orderRepository.findOrderProfileById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    }

    public OrderWithTwoFurnitureProjection18 findOrderWithTwoFurniture18ById(Long id) {
        return orderRepository.findOrderProjection18ById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    }

    public List<OrderListProjection> findListById(Long id) {
        List<OrderListProjection> order = orderRepository.findOrderListById(id);
        if(order.isEmpty())
            throw new OrderNotFoundException("Order " + id + " was not found");
        return order;
    }

    public OrderWithFurnituresProjection findFurnitureById(Long id) {
        return orderRepository.findOrderWithFurnituresById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    }
}
