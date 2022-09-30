package br.sc.senac.budgetech.exception.client;

public class ClientCpfRegisteredException extends RuntimeException {

    public ClientCpfRegisteredException (String message) {
        super(message);
    }
}