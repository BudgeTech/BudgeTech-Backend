package br.sc.senac.urbanwood.backend.dto.furniture;

public record FurnitureDTO(Long id, String nameFurniture, String description, double furnitureSize, double priceFurniture,
                           Long idLivingArea) {
}