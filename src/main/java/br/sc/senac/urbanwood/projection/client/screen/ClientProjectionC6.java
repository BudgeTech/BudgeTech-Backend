package br.sc.senac.urbanwood.projection.client.screen;

public interface ClientProjectionC6 {

    String getNameClient();

    String getLastName();

    String getCpf();

    ImageProjection getImageModel();

    AddressProjection getAddress();

    ContactProjection getContact();

    interface AddressProjection {

        String getStreet();

        String getNumber();

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

    interface ImageProjection {

        byte[] getPicByte();
    }
}
