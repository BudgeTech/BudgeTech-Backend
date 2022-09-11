package br.sc.senac.budgetech.backend.projection.client;

import java.sql.Blob;

public interface ClientProfileFullEditProjection {

    String getNameClient();

    String getLastName();

    String getCpf();

    Blob getImage();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getStreet();

        int getNumber();

        String getComplement();

        String getNeighborhood();

        String getCity();

        String getCep();
    }

    interface ContactProjection {

        String getPhoneNumber();

        String getEmail();

        String getSocialNetwork();
    }
}
