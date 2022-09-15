package br.sc.senac.budgetech.backend.projection.request;

import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkProjection;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

public interface RequestProfileProjection {

    Long getId();

    double getPriceRequest();

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
