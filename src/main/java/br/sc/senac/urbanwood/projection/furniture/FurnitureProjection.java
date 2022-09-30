package br.sc.senac.urbanwood.projection.furniture;

public interface FurnitureProjection {

    Long getId();

    byte[] getImage();

    String getNameFurniture();

    String getDescription();

    Double getFurnitureSize();

    Double getPriceFurniture();
}
