package br.sc.senac.budgetech.backend.repository.order;

import br.sc.senac.budgetech.backend.model.order.Order;
import br.sc.senac.budgetech.backend.projection.order.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<OrderProjection> findOrderByInitialDate(LocalDate initialDate);

    Optional<OrderProjection> findOrderById(Long id);

    List<OrderListProjection> findOrderListBy();

    Optional<OrderProfileProjection> findOrderProfileBy();

//    @Query(value = "select o.id as id, o.finalDate as finalDate, o.initialDate as initialDate, o.priceOrder as priceOrder, o.payment as payment, c.cpf as cpf, c.nameClient as nameClient, a.street as street, a.neighborhood as neighborhood, a.cep as cep, a.city as city, a.number, co.email as email, co.phoneNumber as phoneNumber, f.image as image, f.nameFurniture as nameFurniture, f.priceFurniture as priceFurniture, f.id as id from Order o inner join client c on o.id = c.id inner join address a on o.id = a.id inner join contact co on o.id = co.id inner join furniture f on o.id = f.id", nativeQuery = false)
//    Optional<OrderWithTwoFurnitureProjection18> findOrderProjection18By();

    @Query(value = "select  o.id as id, o.priceOrder as priceOrder, o.payment as payment, o.initialDate as initialDate, o.finalDate as finalDate from Order o")
    Optional<OrderWithTwoFurnitureProjection18> findOrderProjection18By();

    Optional<OrderWithFurnituresProjection> findOrderWithFurnituresBy();
}
