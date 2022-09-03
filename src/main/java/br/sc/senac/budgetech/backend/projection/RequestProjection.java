package br.sc.senac.budgetech.backend.projection;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;

public interface RequestProjection {

    Long getId();

    double getPrice();

    Status getStatus();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();
}
