package br.sc.senac.urbanwood.projection.address;

public interface AddressProjection {

    Long getId();

    String getStreet();

    Integer getNumber();

    String getComplement();

    String getNeighborhood();

    String getCity();

    String getCep();
}
