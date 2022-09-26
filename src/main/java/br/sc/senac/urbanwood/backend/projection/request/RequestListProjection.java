package br.sc.senac.urbanwood.backend.projection.request;

import java.time.LocalDate;

import br.sc.senac.urbanwood.backend.enumeration.Status;

public interface RequestListProjection {

    Long getId();

    LocalDate initialDate();

    double getPriceRequest();

    Status getStatus();
}
