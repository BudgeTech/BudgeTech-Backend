package br.sc.senac.urbanwood.projection.woodwork.screen;

import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;

public interface WoodworkProjectionW7 {

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
    ImageProjection getImageModel();

    interface ImageProjection {

        byte[] getPicByte();
    }
}
