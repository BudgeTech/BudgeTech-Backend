package br.sc.senac.budgetech.projection.address;

public interface AddressProjection {

    Long getId();

    String getStreet();

    Integer getNumber();

    String getComplement();

    String getNeighborhood();

    String getProvince();

    String getCity();

    String getCep();
}
