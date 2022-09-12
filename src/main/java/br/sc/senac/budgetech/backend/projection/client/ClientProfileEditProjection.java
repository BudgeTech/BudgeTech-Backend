package br.sc.senac.budgetech.backend.projection.client;

import java.sql.Blob;

public interface ClientProfileEditProjection {

    String getNameClient();

    String getLastName();

    String getCpf();

    Blob getImage();
}
