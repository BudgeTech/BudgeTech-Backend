package br.sc.senac.budgetech.exception.contact;

public class ContactEmailInvalidException extends RuntimeException{

    public ContactEmailInvalidException(String message) {
        super(message);
    }
}
