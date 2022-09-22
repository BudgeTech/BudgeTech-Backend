package br.sc.senac.budgetech.backend.projection.woodwork;

public interface WoodworkProfileProjectionC8AndC10 {

    String getCompanyName();

    String getDescription();

    String getCnpj();

    byte[] getImage();

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
