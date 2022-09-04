package br.sc.senac.budgetech.backend.projection;

public interface WoodworkProjection {

	Long getId();

	String getLogin();

	String getCompanyName();

	AddressProjection getAddress();

	ContactProjection getContact();

	interface AddressProjection {

		String getNeighbor();
	}

	interface ContactProjection {

		String getPhoneNumber();
	}
}
