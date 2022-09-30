package br.sc.senac.urbanwood.projection.client;

public interface ClientProjection {

    Long getId();

    String getLogin();

    byte[] getImage();

    String getNameClient();

    String getLastName();

    String getCpf();
}
