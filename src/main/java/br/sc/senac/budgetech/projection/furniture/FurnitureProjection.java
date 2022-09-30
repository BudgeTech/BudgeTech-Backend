package br.sc.senac.budgetech.projection.furniture;

public interface FurnitureProjection {

    Long getId();

    byte[] getImage();

    String getNameFurniture();

    String getDescription();

    Double getFurnitureSize();

    Double getPriceFurniture();
}
