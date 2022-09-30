package br.sc.senac.urbanwood.backend.projection.livingArea;

import java.sql.Blob;

public interface LivingAreaProjection {

	Long getId();

	String getNameLivingArea();

	Blob getImage();

}
