package br.sc.senac.urbanwood.backend.projection.request;

import java.time.LocalDate;

import br.sc.senac.urbanwood.backend.enumeration.Payment;
import br.sc.senac.urbanwood.backend.enumeration.Status;

public interface RequestProjection {

    Long getId();

    double getPriceRequest();

    Status getStatus();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();
}
