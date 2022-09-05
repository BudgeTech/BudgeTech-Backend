package br.sc.senac.budgetech.backend.exception.client;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String message) {
        super(message);
    }
}