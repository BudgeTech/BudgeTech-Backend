package br.sc.senac.budgetech.backend.projection.client;

import java.util.List;

public interface ClientWithAll {

    Long getId();

    String getName();

    String getLastName();

    String getCpf();

    String getLogin();

    ClientWithAddressAndContactProjection.AddressProjection getAddress();

    ClientWithAddressAndContactProjection.ContactProjection getContact();

    List<ClientWithItemProjection.ItemProjection> getItems();
}
