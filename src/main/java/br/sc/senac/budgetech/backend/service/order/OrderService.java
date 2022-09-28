package br.sc.senac.budgetech.backend.service.order;

import br.sc.senac.budgetech.backend.dto.order.OrderCreateDTO;
import br.sc.senac.budgetech.backend.dto.order.OrderDTO;
import br.sc.senac.budgetech.backend.projection.order.OrderC13andW13;
import br.sc.senac.budgetech.backend.projection.order.OrderListProjectionW12;
import br.sc.senac.budgetech.backend.projection.order.OrderProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderWithFurnitureProjectionC13andW13;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface OrderService {

    OrderDTO save(OrderCreateDTO orderCreateDTO);

    void update(OrderCreateDTO orderCreateDTO, Long id);

    void delete(Long id);

    OrderProjection findById(Long id);

    List<OrderProjection> findByInitialDate(LocalDate initialDate);

    List<OrderListProjectionW12> findListBy();

    OrderC13andW13 findOrderWithTwoFurniture18By(Long id);

    Page<OrderListProjectionW12> findWithPaginationAndSortingById(Pageable pageable, Integer page);
}
