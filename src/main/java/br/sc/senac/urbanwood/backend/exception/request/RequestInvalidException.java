package br.sc.senac.urbanwood.backend.exception.request;

public class RequestInvalidException extends RuntimeException{

    public RequestInvalidException(String message) {
        super(message);
    }
}
