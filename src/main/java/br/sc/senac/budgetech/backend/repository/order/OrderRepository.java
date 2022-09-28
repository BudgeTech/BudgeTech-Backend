package br.sc.senac.budgetech.backend.repository.order;

import br.sc.senac.budgetech.backend.model.order.Order;
import br.sc.senac.budgetech.backend.projection.client.ClientOrderProjection;
import br.sc.senac.budgetech.backend.projection.order.*;
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

    List<OrderProjection> findOrderByInitialDate(LocalDate initialDate);

    Optional<OrderProjection> findOrderById(Long id);

    List<OrderListProjectionW12> findOrderListBy();

//    @Query(value = """
//    select o.id as id, o.priceOrder as priceOrder, o.payment as payment, o.initialDate as initialDate, o.finalDate as finalDate,
//    f.image as image, f.nameFurniture as nameFurniture, f.priceFurniture as priceFurniture, f.id as id,
//    c.nameClient as nameClient, c.cpf as cpf,
//    co.email as email, co.phoneNumber as phoneNumber,
//    a.street as street, a.neighborhood as neighborhood, a.cep as cep, a.number as number, a.city as city
//    from Order o
//    inner join Furniture f on o.id = f.id
//    inner join Client c on o.id = c.id
//    inner join Contact co on c.id = co.id
//    inner join Address a on c.id = a.id
//    where o.id = ?1
//    """)
//    List<OrderC13andW13> findOrderProjection18By(Long id);

    @Query(value = """
            select o.id as id, o.priceOrder as priceOrder, o.payment as payment, o.initialDate as initialDate, o.finalDate as finalDate,
            f.image as image, f.nameFurniture as nameFurniture, f.priceFurniture as priceFurniture, f.id as id,
            from Order o
            inner join Furniture f on o.id = f.id
            where o.id = ?1
            """)
    OrderWithFurnitureProjectionC13andW13 findOrderProjection18By(Long id);

    @Query(value = "select o.id as id, o.initialDate as initialDate, o.priceOrder as priceOrder, o.status as status from Order o")
    Page<OrderListProjectionW12> findOrderListW12By(Pageable pageable);
}
