package br.sc.senac.urbanwood.backend.exception.address;

public class AddressInvalidException extends RuntimeException{

    public AddressInvalidException(String message) {
        super(message);
    }
}
