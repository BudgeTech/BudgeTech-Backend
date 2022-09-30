package br.sc.senac.urbanwood.backend.exception.item;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String message) {
        super(message);
    }
}
