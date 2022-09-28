package br.sc.senac.budgetech.backend.projection.order;

import br.sc.senac.budgetech.backend.enumeration.Payment;

import java.time.LocalDate;
import java.util.List;

public interface OrderWithFurnitureProjectionC13andW13 {

    Double getPriceOrder();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();

    Long getId();

    String getNameClient();

    String getCpf();

    String getEmail();

    String getPhoneNumber();

    String getStreet();

    String getNeighborhood();

    String getCep();

    int getNumber();

    String getCity();
}
