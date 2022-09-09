package br.sc.senac.budgetech.backend.exception.client;

public class ClientLoginRegisteredException extends RuntimeException{

    public ClientLoginRegisteredException(String message) {
        super(message);
    }
}
