package br.sc.senac.urbanwood.projection.order.screen;

import br.sc.senac.urbanwood.enumeration.payment.Payment;
import br.sc.senac.urbanwood.enumeration.status.Status;

import java.time.LocalDate;
import java.util.List;

public interface OrderProjectionW13 {

    Status getStatus();

    Double priceOrder();

    Payment getPayment();

    LocalDate getInitialDate();

    LocalDate getFinalDate();

    Long getId();

    ItemProjection getItem();

    List<FurnitureProjection> getFurniture();

    interface ItemProjection {

        ClientProjection getClient();

        interface ClientProjection {

            String getNameClient();

            String getCpf();

            AddressProjection getAddress();

            ContactProjection getContact();

            interface AddressProjection {

                String getStreet();

                String getNeighborhood();

                String getCep();

                String getNumber();

                String getCity();
            }

            interface ContactProjection {

                String getEmail();

                String getPhoneNumber();
            }
        }
    }

    interface FurnitureProjection {

        String getNameFurniture();

        Long getId();

        Double getPriceFurniture();

        byte[] getImage();
    }
}
