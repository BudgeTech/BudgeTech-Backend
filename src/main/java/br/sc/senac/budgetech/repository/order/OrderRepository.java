package br.sc.senac.budgetech.repository.order;

import br.sc.senac.budgetech.model.order.Order;
import br.sc.senac.budgetech.projection.order.OrderProjection;
import br.sc.senac.budgetech.projection.order.screen.OrderProjectionW12;
import br.sc.senac.budgetech.projection.order.screen.OrderProjectionW13;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<OrderProjection> findOrderById(Long id);

    List<OrderProjection> findOrderByInitialDate(LocalDate initialDate);

    //Screen

    @Query(value = """
            select o.id as id, o.initialDate as initialDate, o.priceOrder as priceOrder, o.status as status
            from Order o
            """)
    Page<OrderProjectionW12> findOrderW12OrderByInitialDate(Pageable pageable);

    Optional<OrderProjectionW13> findOrderW13ById(Long id);
}
