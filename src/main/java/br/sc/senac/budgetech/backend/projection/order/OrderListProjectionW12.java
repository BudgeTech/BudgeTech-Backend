package br.sc.senac.budgetech.backend.projection.order;

import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;

public interface OrderListProjectionW12 {

    Long getId();

    LocalDate initialDate();

    Double getPriceOrder();

    Status getStatus();
}
