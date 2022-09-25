package br.sc.senac.budgetech.backend.projection.client;

import java.time.LocalDate;

public interface OrderProjectionW10 {

    Long getId();

    LocalDate getInitialDate();

    Double getPriceOrder();
}
