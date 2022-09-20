package br.sc.senac.budgetech.backend.exception.contact;

public class ContactEmailInvalidException extends RuntimeException{

    public ContactEmailInvalidException(String message) {
        super(message);
    }
}
