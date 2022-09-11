package br.sc.senac.budgetech.backend.projection.woodwork;

public interface WoodworkProfileProjection {

    String getCompanyName();

    String getDescription();

    String getCnpj();

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
