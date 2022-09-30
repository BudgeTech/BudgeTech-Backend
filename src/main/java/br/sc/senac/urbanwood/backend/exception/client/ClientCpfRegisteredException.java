package br.sc.senac.urbanwood.backend.exception.client;

public class ClientCpfRegisteredException extends RuntimeException {

    public ClientCpfRegisteredException (String message) {
        super(message);
    }
}