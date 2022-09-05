package br.sc.senac.budgetech.backend.projection;

public interface ItemProjection {

    Long getId();

    int getQuantity();

    double getTotalPrice();
}
