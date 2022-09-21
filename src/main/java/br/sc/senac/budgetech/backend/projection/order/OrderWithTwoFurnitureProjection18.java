package br.sc.senac.budgetech.backend.projection.order;

import br.sc.senac.budgetech.backend.enumeration.Payment;

import java.time.LocalDate;
import java.util.List;

public interface OrderWithTwoFurnitureProjection18 {

    Long getId();

    Double getPriceOrder();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();

    List<FurnitureProjection> getFurniture();
//
//    AddressProjection getAddress();
//
//    ContactProjection getContact();
//
//    ClientProjection getClient();
//
//    interface ClientProjection {
//
//            String getNameClient();
//
//            String getCpf();
//    }
//
//    interface AddressProjection {
//
//        String getStreet();
//
//        String getNeighborhood();
//
//        String getCep();
//
//        String getCity();
//
//        int getNumber();
//    }
//
//    interface ContactProjection {
//
//        String getEmail();
//
//        String getPhonenumber();
//    }
//
    interface FurnitureProjection {

        byte[] getImage();

        String getNameFurniture();

        Double getPriceFurniture();

        Long getId();
    }
}
