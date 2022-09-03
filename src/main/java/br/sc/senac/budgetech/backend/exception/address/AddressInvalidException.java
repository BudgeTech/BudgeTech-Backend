package br.sc.senac.budgetech.backend.exception.address;

public class AddressInvalidException extends RuntimeException{

    public AddressInvalidException(String message) {
        super(message);
    }
}
