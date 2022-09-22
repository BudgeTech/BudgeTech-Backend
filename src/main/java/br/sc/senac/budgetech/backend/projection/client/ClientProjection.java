package br.sc.senac.budgetech.backend.projection.client;

public interface ClientProjection {

    Long getId();

    String getLogin();

    byte[] getImage();

    String getNameClient();

    String getCpf();

    String getLastName();
}
