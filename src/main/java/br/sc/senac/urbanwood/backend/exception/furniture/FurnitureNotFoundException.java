package br.sc.senac.urbanwood.backend.exception.furniture;

public class FurnitureNotFoundException extends RuntimeException {
	
	public FurnitureNotFoundException(String message) {
		super(message);
	}
}