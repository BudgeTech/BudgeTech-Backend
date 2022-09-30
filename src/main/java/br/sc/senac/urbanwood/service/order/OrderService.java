package br.sc.senac.urbanwood.service.order;

import br.sc.senac.urbanwood.dto.order.OrderCreateDTO;
import br.sc.senac.urbanwood.dto.order.OrderDTO;
import br.sc.senac.urbanwood.projection.order.OrderProjection;
import br.sc.senac.urbanwood.projection.order.screen.OrderProjectionW12;
import br.sc.senac.urbanwood.projection.order.screen.OrderProjectionW13;
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

    //Screen

    Page<OrderProjectionW12> findW12OrderByInitialDate(Pageable pageable, Integer page);

    OrderProjectionW13 findW13ById(Long id);
}
