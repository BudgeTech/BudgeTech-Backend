package br.sc.senac.urbanwood.projection.order;

import br.sc.senac.urbanwood.enumeration.payment.Payment;
import br.sc.senac.urbanwood.enumeration.status.Status;

import java.time.LocalDate;

public interface OrderProjection {

    Long getId();

    Double getPriceOrder();

    Status getStatus();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();
}
