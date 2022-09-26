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

//    List<FurnitureProjection> getFurniture();

//    ItemProjection.ClientProjection.AddressProjection getAddress();
//
//    ItemProjection.ClientProjection.ContactProjection getContact();
//
//    ItemProjection.ClientProjection getClient();
//
//    interface ItemProjection {
//
//        interface ClientProjection {
//
//            String getNameClient();
//
//            String getCpf();
//
//            interface ContactProjection {
//
//                String getEmail();
//
//                String getPhoneNumber();
//            }
//
//            interface AddressProjection {
//
//                String getStreet();
//
//                String getNeighborhood();
//
//                String getCep();
//
//                int getNumber();
//
//                String getCity();
//            }
//        }
//    }

    interface FurnitureProjection {

        byte[] getImage();

        String getNameFurniture();

        Long getId();

        Double getPriceFurniture();
    }
}
