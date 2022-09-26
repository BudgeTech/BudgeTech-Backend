package br.sc.senac.urbanwood.backend.exception.client;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String message) {
        super(message);
    }
}