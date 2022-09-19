package br.sc.senac.budgetech.backend.projection.order;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;

public interface OrderProjection {

    Long getId();

    double getPriceOrder();

    Status getStatus();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();
}
