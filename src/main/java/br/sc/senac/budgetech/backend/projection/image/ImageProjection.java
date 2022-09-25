package br.sc.senac.budgetech.backend.projection.image;

import java.util.List;

import br.sc.senac.budgetech.backend.model.Image;

public interface ImageProjection {

	Long getId();

	String getName();

	String getType();

	List<Image> getPicByte();
}
