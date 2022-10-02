package br.sc.senac.urbanwood.projection.client;

public interface ClientProjection {

    Long getId();

    String getLogin();

    String getNameClient();

    String getLastName();

    String getCpf();

    ImageProjection getImageModel();


    interface ImageProjection {

        byte[] getPicByte();
    }
}
