package br.sc.senac.budgetech.backend.mapper.order;

import br.sc.senac.budgetech.backend.dto.order.OrderCreateDTO;
import br.sc.senac.budgetech.backend.dto.order.OrderDTO;
import br.sc.senac.budgetech.backend.model.order.Order;
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
