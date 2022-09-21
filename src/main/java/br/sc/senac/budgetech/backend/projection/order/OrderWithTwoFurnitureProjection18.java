package br.sc.senac.budgetech.backend.projection.order;

import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;

import java.util.List;

public interface OrderWithTwoFurnitureProjection18 {

    List<FurnitureProjection> getFurniture();

    ClientProjection getClient();


    interface ClientProjection {

        String getNameClient();
    }

//    ItemProjection.ClientProjection getClient();
//
//    ItemProjection.ClientProjection.ContactProjection getContact();
//
//    ItemProjection.ClientProjection.AddressProjection getAddress();
//
//    interface ItemProjection {
//    interface ClientProjection {
//
//        String getNameClient();
//
//        String getCpf();
//    }
//}
//
//            interface ContactProjection {
//
//                String getNumber();
//
//                String getEmail();
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
//                String getCity();
//            }
//        }
//    }
//
//    interface FurnitureProjection {
//
//        String getNameFurniture();
//
//        Double getPriceFurniture();
//
//        Long getId();
//
//        byte[] getImage();
//    }
}
