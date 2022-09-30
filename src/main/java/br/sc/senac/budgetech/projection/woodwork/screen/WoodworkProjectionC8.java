package br.sc.senac.budgetech.projection.woodwork.screen;

public interface WoodworkProjectionC8 {

    String getCompanyName();

    String getDescription();

    String getCnpj();

    byte[] getImage();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getProvince();

        String getCity();

        String getNeighborhood();
    }

    interface ContactProjection {

        String getPhoneNumber();

        String getEmail();

        String getSocialNetwork();
    }
}
