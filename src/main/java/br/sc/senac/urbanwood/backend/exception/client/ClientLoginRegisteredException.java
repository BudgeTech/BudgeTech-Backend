package br.sc.senac.urbanwood.backend.exception.client;

public class ClientLoginRegisteredException extends RuntimeException{

    public ClientLoginRegisteredException(String message) {
        super(message);
    }
}
