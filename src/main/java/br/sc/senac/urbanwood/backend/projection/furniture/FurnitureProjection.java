package br.sc.senac.urbanwood.backend.projection.furniture;

import java.sql.Blob;

public interface FurnitureProjection {

    Long getId();

    String getNameFurniture();

    String getDescription();

    double getFurnitureSize();

    double getPriceFurniture();

    Blob getImage();
}
