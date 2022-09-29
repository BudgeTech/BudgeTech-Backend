package br.sc.senac.budgetech.exception.furniture;

public class FurnitureNotFoundException extends RuntimeException {
	
	public FurnitureNotFoundException(String message) {
		super(message);
	}
}