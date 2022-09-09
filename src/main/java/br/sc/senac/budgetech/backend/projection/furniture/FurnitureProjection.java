package br.sc.senac.budgetech.backend.projection.furniture;

import java.sql.Blob;

public interface FurnitureProjection {

    Long getId();

    String getName();

    String getDescription();

    double getFurnitureSize();

    double getPrice();

    Blob getImage();
}
