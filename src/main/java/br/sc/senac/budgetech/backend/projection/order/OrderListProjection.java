package br.sc.senac.budgetech.backend.projection.order;

import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;

public interface OrderListProjection {

    Long getId();

    LocalDate initialDate();

    double getPriceOrder();

    Status getStatus();
}
