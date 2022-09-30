package br.sc.senac.urbanwood.backend.exception.client;

public class ClientCpfInvalidException extends RuntimeException{

    public ClientCpfInvalidException(String message) {
        super(message);
    }
}
