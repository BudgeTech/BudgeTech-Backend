package br.sc.senac.budgetech.backend.projection.furniture;

import java.sql.Blob;

public interface FurnitureProjection {

    Long getId();

    String getNameFurniture();

    String getDescription();

    Double getFurnitureSize();

    Double getPriceFurniture();

    Blob getImage();
}
