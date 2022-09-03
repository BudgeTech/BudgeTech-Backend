package br.sc.senac.budgetech.backend.exception.item;

public class ItemInvalidException extends RuntimeException{

    public ItemInvalidException(String message) {
        super(message);
    }
}
