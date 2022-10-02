package br.sc.senac.urbanwood.projection.client.screen;

public interface ClientProjectionW9 {

    Long getId();

    String getNameClient();

    String getLastName();

    String getNeighborhood();

    String getCity();

    String getPhoneNumber();

    ImageProjection getImageModel();

    interface ImageProjection {

        byte[] getPicByte();
    }
}
