package br.sc.senac.budgetech.backend.exception.client;

public class ClientCpfInvalidException extends RuntimeException{

    public ClientCpfInvalidException(String message) {
        super(message);
    }
}
