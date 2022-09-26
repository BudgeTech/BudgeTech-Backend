package br.sc.senac.urbanwood.backend.exception.contact;

public class ContactEmailRegisteredException extends RuntimeException {

    public ContactEmailRegisteredException(String message) {
        super(message);
    }
}