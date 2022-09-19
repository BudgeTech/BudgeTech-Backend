package br.sc.senac.budgetech.backend.projection.client;

public interface ClientListProjection {

    Long getId();

    String getName();

    String getLastName();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getNeighborhood();

        String getCity();
    }

    interface ContactProjection {

        String getPhoneNumber();
    }
}
