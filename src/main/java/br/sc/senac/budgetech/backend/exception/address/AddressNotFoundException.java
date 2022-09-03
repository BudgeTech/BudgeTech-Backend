package br.sc.senac.budgetech.backend.exception.address;

public class AddressNotFoundException extends RuntimeException{
	
	public AddressNotFoundException(String message) {
		super(message);
	}
}