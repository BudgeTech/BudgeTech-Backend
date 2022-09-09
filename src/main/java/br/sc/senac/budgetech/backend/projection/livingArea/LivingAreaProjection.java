package br.sc.senac.budgetech.backend.projection.livingArea;

import java.sql.Blob;

public interface LivingAreaProjection {

	Long getId();

	String getName();

	Blob getImage();

}
