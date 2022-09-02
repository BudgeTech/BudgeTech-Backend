package br.sc.senac.budgetech.backend.projection;

public interface ItemWithFurnitureProjection {

	int getQuantity();
	double getTotalPrice();

	interface FurnitureBasicProjection{
		Long getId();
		Double getName();
	}
} 
