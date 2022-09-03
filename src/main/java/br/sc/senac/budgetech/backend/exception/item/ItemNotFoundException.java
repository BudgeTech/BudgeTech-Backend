package br.sc.senac.budgetech.backend.exception.item;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String message) {
        super(message);
    }
}
