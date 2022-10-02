package br.sc.senac.urbanwood.projection.woodwork;

public interface WoodworkProjection {

	Long getId();

	String getLogin();

	String getCnpj();

	String getCompanyName();

	String getDescription();

	ImageProjection getImageModel();

	interface ImageProjection {

		byte[] getPicByte();
	}
}
