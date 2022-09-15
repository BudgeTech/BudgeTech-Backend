package br.sc.senac.budgetech.backend.projection.furniture;

public interface FurnitureProjection {

    Long getId();

    String getNameFurniture();

    String getDescription();

    Double getFurnitureSize();

    Double getPriceFurniture();

    byte[] getImage();
}
