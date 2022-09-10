package br.sc.senac.budgetech.backend.projection.request;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;

public interface RequestProjection {

    Long getId();

    double getPriceRequest();

    Status getStatus();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();
}
