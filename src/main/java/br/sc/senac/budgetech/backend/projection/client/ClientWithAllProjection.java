package br.sc.senac.budgetech.backend.projection.client;

import java.util.List;

public interface ClientWithAllProjection {

    Long getId();

    String getNameClient();

    String getLastName();

    String getCpf();

    String getLogin();

    ClientWithAddressAndContactProjection.AddressProjection getAddress();

    ClientWithAddressAndContactProjection.ContactProjection getContact();

    List<ClientWithItemProjection.ItemProjection> getItems();
}
