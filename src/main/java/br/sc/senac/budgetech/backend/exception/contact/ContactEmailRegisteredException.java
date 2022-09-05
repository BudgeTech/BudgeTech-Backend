package br.sc.senac.budgetech.backend.exception.contact;

public class ContactEmailRegisteredException extends RuntimeException {

    public ContactEmailRegisteredException(String message) {
        super(message);
    }
}