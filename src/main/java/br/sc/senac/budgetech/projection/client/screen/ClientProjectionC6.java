package br.sc.senac.budgetech.projection.client.screen;

public interface ClientProjectionC6 {

    byte[] getImage();

    String getNameClient();

    String getLastName();

    String getCpf();

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
}
