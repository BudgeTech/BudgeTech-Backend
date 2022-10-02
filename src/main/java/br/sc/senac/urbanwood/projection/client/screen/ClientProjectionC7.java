package br.sc.senac.urbanwood.projection.client.screen;

public interface ClientProjectionC7 {

    String getNameClient();

    String getLastName();

    ImageProjection getImageModel();

    interface ImageProjection {

        byte[] getPicByte();
    }
}
