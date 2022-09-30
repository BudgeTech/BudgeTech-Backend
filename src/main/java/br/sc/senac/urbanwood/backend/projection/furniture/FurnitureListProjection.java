package br.sc.senac.urbanwood.backend.projection.furniture;

import java.sql.Blob;

public interface FurnitureListProjection {

    String getNameFurniture();

    String getPriceFurniture();

    Blob getImage();
}
