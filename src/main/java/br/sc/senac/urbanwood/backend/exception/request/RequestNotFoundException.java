package br.sc.senac.urbanwood.backend.exception.request;

public class RequestNotFoundException extends RuntimeException{

    public RequestNotFoundException(String message) {
        super(message);
    }
}
