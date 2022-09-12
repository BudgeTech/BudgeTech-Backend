package br.sc.senac.budgetech.backend.projection.request;

import java.sql.Blob;
import java.util.List;

public interface RequestWithFurnituresProjection {

    List<FurnitureProjection> getFurniture();

    interface FurnitureProjection {

        String getNameFurniture();

        Double getPriceFurniture();

        Long getId();

        Blob getImage();
    }
}
