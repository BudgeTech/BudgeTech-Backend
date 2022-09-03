package br.sc.senac.budgetech.backend.exception.client;

public class ClientCpfRegisteredException extends RuntimeException {

    public ClientCpfRegisteredException (String message) {
        super(message);
    }
}