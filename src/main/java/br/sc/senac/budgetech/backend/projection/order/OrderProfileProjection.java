package br.sc.senac.budgetech.backend.projection.order;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

public interface OrderProfileProjection {

    Long getId();

    double getPriceOrder();

    ItemProjection getItem();

    LocalDate getInitialDate();

    List<FurnitureProjection> getFurniture();

    interface ItemProjection {

        ClientProjection getClient();

        WoodworkProjection getWoodwork();

        interface WoodworkProjection {
            Blob getImage();
        }

        interface ClientProjection {

            ContactProjection getContact();

            AddressProjection getAddress();

            String getNameClient();

            String getCpf();

            interface ContactProjection {

                String getEmail();

                String getPhoneNumber();
            }

            interface AddressProjection {

                int getNumber();

                String getNeighborhood();

                String getCity();

                String getCep();
            }
        }
    }

    interface FurnitureProjection {

        String getNameFurniture();

        double getPriceFurniture();
    }
}
