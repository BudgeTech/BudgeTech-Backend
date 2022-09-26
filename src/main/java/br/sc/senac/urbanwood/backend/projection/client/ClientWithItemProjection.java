package br.sc.senac.urbanwood.backend.projection.client;

import java.util.List;

public interface ClientWithItemProjection {

    String getNameClient();

    List<ItemProjection> getItems();

    interface ItemProjection{

        Long getId();

        int getQuantity();

        double getTotalPrice();
    }
}
