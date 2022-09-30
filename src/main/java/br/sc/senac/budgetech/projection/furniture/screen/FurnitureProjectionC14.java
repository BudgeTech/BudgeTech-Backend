package br.sc.senac.budgetech.projection.furniture.screen;

import java.util.List;

public interface FurnitureProjectionC14 {

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
