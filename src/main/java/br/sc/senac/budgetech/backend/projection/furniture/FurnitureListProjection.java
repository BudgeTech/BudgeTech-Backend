package br.sc.senac.budgetech.backend.projection.furniture;

import java.sql.Blob;

public interface FurnitureListProjection {

    String getNameFurniture();

    String getPriceFurniture();

    Blob getImage();
}
