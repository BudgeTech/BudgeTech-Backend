package br.sc.senac.budgetech.backend.projection.client;

import java.time.LocalDate;
import java.util.List;

public interface ClientProfileFullEditProjectionW10 {

    byte[] getImage();

    String getNameClient();

    String getLastName();

    String getCpf();

    List<OrderProjection> getOrder();

    interface AddressProjection {

        String getStreet();

        Integer getNumber();

        String getComplement();

        String getNeighborhood();

        String getCity();

        String getCep();
    }

    interface ContactProjection {

        String getEmail();

        String getPhoneNumber();

        String getSocialNetwork();

    }

    interface OrderProjection {

        Long getId();

        LocalDate getInitialDate();

        Double getPriceOrder();
    }
}
