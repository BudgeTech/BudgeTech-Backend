package br.sc.senac.budgetech.backend.projection.request;

import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;

public interface RequestListProjection {

    Long getId();

    LocalDate initialDate();

    double getPriceRequest();

    Status getStatus();
}
