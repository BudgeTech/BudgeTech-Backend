package br.sc.senac.budgetech.backend.projection.woodwork;

public interface WoodworkProfileFullEditProjection {

    String getCompanyName();

    String getCnpj();

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
