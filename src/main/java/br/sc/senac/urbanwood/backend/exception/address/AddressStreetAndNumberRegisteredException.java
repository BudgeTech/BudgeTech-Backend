package br.sc.senac.urbanwood.backend.exception.address;

public class AddressStreetAndNumberRegisteredException extends RuntimeException{

    public AddressStreetAndNumberRegisteredException(String message) {
        super(message);
    }
}