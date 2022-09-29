package br.sc.senac.budgetech.exception.order;

public class OrderInvalidException extends RuntimeException{

    public OrderInvalidException(String message) {
        super(message);
    }
}
