package br.sc.senac.urbanwood.projection.order.screen;

import br.sc.senac.urbanwood.enumeration.status.Status;

import java.time.LocalDate;

public interface OrderProjectionW12 {

    Long getId();

    LocalDate getInitialDate();

    Double getPriceOrder();

    Status getStatus();
}
