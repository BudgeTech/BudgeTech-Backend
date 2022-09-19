package br.sc.senac.budgetech.backend.exception.order;

public class OrderInvalidException extends RuntimeException{

    public OrderInvalidException(String message) {
        super(message);
    }
}
