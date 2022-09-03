package br.sc.senac.budgetech.backend.exception.address;

public class AddressStreetAndNumberRegisteredException extends RuntimeException{

    public AddressStreetAndNumberRegisteredException(String message) {
        super(message);
    }
}