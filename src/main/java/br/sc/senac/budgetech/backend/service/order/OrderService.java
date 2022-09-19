package br.sc.senac.budgetech.backend.service.order;

import br.sc.senac.budgetech.backend.dto.order.*;
import br.sc.senac.budgetech.backend.projection.order.OrderListProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderProfileProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderWithFurnituresProjection;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface OrderService {

    OrderDTO save(OrderCreateDTO orderCreateDTO);

    void update(OrderCreateDTO orderCreateDTO, Long id);

    void delete(Long id);

    OrderProjection findById(Long id);

    OrderProjection findByInitialDate(LocalDate initialDate);

    OrderProfileProjection findProfileById(Long id);

    List<OrderListProjection> findListById(Long id);

    OrderWithFurnituresProjection findFurnitureById(Long id);
}
