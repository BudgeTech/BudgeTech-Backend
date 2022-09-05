package br.sc.senac.budgetech.backend.exception.contact;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(String message) {
        super(message);
    }
}