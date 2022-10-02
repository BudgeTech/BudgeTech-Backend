package br.sc.senac.urbanwood.projection.woodwork.screen;

import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;

public interface WoodworkProjectionC8 {

    String getCompanyName();

    String getDescription();

    String getCnpj();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getCity();

        String getNeighborhood();
    }

    interface ContactProjection {

        String getPhoneNumber();

        String getEmail();

        String getSocialNetwork();
    }

    ImageProjection getImageModel();

    interface ImageProjection {

        byte[] getPicByte();
    }
}
