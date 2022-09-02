package br.sc.senac.budgetech.backend.projection;

import java.time.LocalDate;

import br.sc.senac.budgetech.backend.enumeration.Status;

public interface RequestBasicProjection {

	Long getId();

	LocalDate getInitialDate();

	Double getPrice();

	Status getStatus();

}
