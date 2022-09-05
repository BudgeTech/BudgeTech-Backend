package br.sc.senac.budgetech.backend.projection;

public interface FurnitureProjection {

    Long getId();

    String getName();

    String getDescription();

    double getFurnitureSize();

    double getPrice();
}
