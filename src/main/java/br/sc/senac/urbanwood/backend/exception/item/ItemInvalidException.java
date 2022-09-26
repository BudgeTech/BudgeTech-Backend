package br.sc.senac.urbanwood.backend.exception.item;

public class ItemInvalidException extends RuntimeException{

    public ItemInvalidException(String message) {
        super(message);
    }
}
