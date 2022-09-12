package br.sc.senac.budgetech.backend.projection.woodwork;

import java.sql.Blob;

public interface WoodworkProfileProjection {

    String getCompanyName();

    String getDescription();

    String getCnpj();

    Blob getImage();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getCity();

        String getProvince();

        String getNeighborhood();
    }

    interface ContactProjection {

        String getPhoneNumber();

        String getEmail();

        String getSocialNetwork();
    }
}
