package br.sc.senac.budgetech.backend.projection.furniture;

import java.util.List;

public interface FurnitureFullProjection {

    Long getId();

    byte[] getImage();

    String getNameFurniture();

    String getDescription();

    Double getFurnitureSize();

    Double getPriceFurniture();

    List<ColorProjection> getColors();

    interface ColorProjection {

        String getNameColor();
    }
}
