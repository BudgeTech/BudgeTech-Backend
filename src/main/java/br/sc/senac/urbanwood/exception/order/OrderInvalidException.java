package br.sc.senac.urbanwood.exception.order;

public class OrderInvalidException extends RuntimeException{

    public OrderInvalidException(String message) {
        super(message);
    }
}
