package br.sc.senac.urbanwood.exception.client;

public class ClientCpfRegisteredException extends RuntimeException {

    public ClientCpfRegisteredException (String message) {
        super(message);
    }
}