package br.sc.senac.budgetech.projection.order;

import br.sc.senac.budgetech.enumeration.payment.Payment;
import br.sc.senac.budgetech.enumeration.status.Status;

import java.time.LocalDate;

public interface OrderProjection {

    Long getId();

    Double getPriceOrder();

    Status getStatus();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();
}
