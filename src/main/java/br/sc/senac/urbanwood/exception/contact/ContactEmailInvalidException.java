package br.sc.senac.urbanwood.exception.contact;

public class ContactEmailInvalidException extends RuntimeException{

    public ContactEmailInvalidException(String message) {
        super(message);
    }
}
