package br.sc.senac.budgetech.backend.projection.client;

public interface ClientProjection {

    Long getId();

    String getName();

    String getLastName();

    String getLogin();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getNeighbor();

        String getCity();
    }

    interface ContactProjection{

        String getPhoneNumber();
    }
}
