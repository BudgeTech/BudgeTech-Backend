package br.sc.senac.budgetech.backend.exception.request;

public class RequestNotFoundException extends RuntimeException{

    public RequestNotFoundException(String message) {
        super(message);
    }
}
