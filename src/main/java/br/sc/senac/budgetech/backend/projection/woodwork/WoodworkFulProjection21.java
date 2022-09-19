package br.sc.senac.budgetech.backend.projection.woodwork;

public interface WoodworkFulProjection21 {

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

        String getEmail();

        String getSocialNetwork();

        String getPhoneNumber();
    }
}
