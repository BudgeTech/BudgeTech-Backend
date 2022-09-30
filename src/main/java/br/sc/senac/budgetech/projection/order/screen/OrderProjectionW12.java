package br.sc.senac.budgetech.projection.order.screen;

import br.sc.senac.budgetech.enumeration.status.Status;

import java.time.LocalDate;

public interface OrderProjectionW12 {

    Long getId();

    LocalDate getInitialDate();

    Double getPriceOrder();

    Status getStatus();
}
