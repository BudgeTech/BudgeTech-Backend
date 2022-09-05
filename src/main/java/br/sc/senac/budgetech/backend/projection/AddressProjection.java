package br.sc.senac.budgetech.backend.projection;

public interface AddressProjection {

    Long getId();

    String getStreet();

    int getNumber();

    String getComplement();

    String getNeighbor();

    String getCity();

    String getProvince();

    String getCep();
}
