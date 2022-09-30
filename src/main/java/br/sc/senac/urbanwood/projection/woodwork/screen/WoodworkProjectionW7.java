package br.sc.senac.urbanwood.projection.woodwork.screen;

public interface WoodworkProjectionW7 {

    byte[] getImage();

    String getCompanyName();

    String getCnpj();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getStreet();

        Integer getNumber();

        String getComplement();

        String getNeighborhood();

        String getCity();

        String getCep();
    }

    interface ContactProjection {

        String getEmail();

        String getPhoneNumber();

        String getSocialNetwork();
    }
}
