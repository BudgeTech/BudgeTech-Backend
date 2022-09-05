package br.sc.senac.budgetech.backend.exception.furniture;

public class FurnitureNotFoundException extends RuntimeException {
	
	public FurnitureNotFoundException(String message) {
		super(message);
	}
}