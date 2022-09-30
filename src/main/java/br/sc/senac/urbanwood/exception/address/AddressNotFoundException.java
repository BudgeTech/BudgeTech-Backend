package br.sc.senac.urbanwood.exception.address;

public class AddressNotFoundException extends RuntimeException{
	
	public AddressNotFoundException(String message) {
		super(message);
	}
}