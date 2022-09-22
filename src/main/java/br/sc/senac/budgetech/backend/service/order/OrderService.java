package br.sc.senac.budgetech.backend.service.order;

import br.sc.senac.budgetech.backend.dto.order.*;
import br.sc.senac.budgetech.backend.projection.order.*;
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

    OrderProjection findByInitialDate(LocalDate initialDate);

    List<OrderListProjectionW12> findListBy();

    OrderWithFurnitureProjectionC13andW13 findOrderWithTwoFurniture18By();

    Page<OrderListProjectionW12> findWithPaginationAndSortingById(Pageable pageable, Integer page);

    //OrderProfileProjection findProfileBy();

    //OrderWithFurnituresProjection findFurnitureBy();
}
