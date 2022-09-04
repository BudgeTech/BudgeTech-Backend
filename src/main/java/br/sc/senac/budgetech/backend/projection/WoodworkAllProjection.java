package br.sc.senac.budgetech.backend.projection;

public interface WoodworkAllProjection {

    Long getId();

    String getLogin();

    String getCompanyName();

    String getDescription();

    String getCnpj();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getStreet();

        int getNumber();

        String getComplement();

        String getNeighbor();

        String getCity();

        String getProvince();

        String getCep();
    }

    interface ContactProjection {

        String getEmail();

        String getPhoneNumber();

        String getSocialNetwork();
    }
}
