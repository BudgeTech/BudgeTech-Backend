package br.sc.senac.urbanwood.mapper.order;

import br.sc.senac.urbanwood.dto.order.OrderCreateDTO;
import br.sc.senac.urbanwood.dto.order.OrderDTO;
import br.sc.senac.urbanwood.model.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public OrderDTO toDTO(Order order) {
        return new OrderDTO(order.getId(), order.getPriceOrder(), order.getStatus(), order.getPayment(), order.getInitialDate(), order.getFinalDate());
    }

    public Order toEntity(OrderCreateDTO dto) {
        return new Order(dto.id(), dto.priceOrder(), dto.status(), dto.payment(), dto.initialDate(), dto.finalDate());
    }
}
