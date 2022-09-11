package br.sc.senac.budgetech.backend.projection.furniture;

import java.sql.Blob;

public interface FurnitureListProjection {

    String getNameFurniture();

    double getPriceFurniture();

    //Blob getImage();
}
