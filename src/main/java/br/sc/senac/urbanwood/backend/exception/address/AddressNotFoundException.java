package br.sc.senac.urbanwood.backend.exception.address;

public class AddressNotFoundException extends RuntimeException{
	
	public AddressNotFoundException(String message) {
		super(message);
	}
}