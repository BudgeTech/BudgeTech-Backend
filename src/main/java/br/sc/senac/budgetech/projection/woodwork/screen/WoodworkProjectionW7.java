package br.sc.senac.budgetech.projection.woodwork.screen;

public interface WoodworkProjectionW7 {

    byte[] getImage();

    String getCompanyName();

    String getCnpj();

    interface AddressProjection {

        String getStreet();



    }
}
