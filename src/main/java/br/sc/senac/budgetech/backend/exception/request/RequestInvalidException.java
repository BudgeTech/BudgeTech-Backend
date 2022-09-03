package br.sc.senac.budgetech.backend.exception.request;

public class RequestInvalidException extends RuntimeException{

    public RequestInvalidException(String message) {
        super(message);
    }
}
