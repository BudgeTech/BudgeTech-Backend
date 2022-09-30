package br.sc.senac.budgetech.projection.woodwork;

public interface WoodworkProjection {

	Long getId();

	String getLogin();

	byte[] getImage();

	String getCnpj();

	String getCompanyName();

	String getDescription();
}
