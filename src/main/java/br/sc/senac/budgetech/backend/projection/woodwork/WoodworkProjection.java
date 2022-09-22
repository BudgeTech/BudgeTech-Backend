package br.sc.senac.budgetech.backend.projection.woodwork;

public interface WoodworkProjection {

	Long getId();

	String getLogin();

	String getCnpj();

	byte[] getImage();

	String getCompanyName();

	String getDescription();
}
