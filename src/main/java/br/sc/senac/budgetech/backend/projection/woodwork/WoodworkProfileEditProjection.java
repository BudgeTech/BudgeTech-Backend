package br.sc.senac.budgetech.backend.projection.woodwork;

import java.sql.Blob;

public interface WoodworkProfileEditProjection {

    String getCompanyName();

    String getCnpj();

    Blob getImage();
}
