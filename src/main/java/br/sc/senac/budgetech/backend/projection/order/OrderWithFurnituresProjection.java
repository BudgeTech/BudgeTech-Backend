package br.sc.senac.budgetech.backend.projection.order;

import java.sql.Blob;
import java.util.List;

public interface OrderWithFurnituresProjection {

    List<FurnitureProjection> getFurniture();

    interface FurnitureProjection {

        String getNameFurniture();

        double getPriceFurniture();

        Long getId();

        byte[] getImage();
    }
}
