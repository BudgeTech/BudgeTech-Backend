package br.sc.senac.urbanwood.dto.furniture;

public record FurnitureDTO(Long id,
                           String nameFurniture,
                           String description,
                           Double furnitureSize,
                           Double priceFurniture,
                           byte[] image,
                           Long idLivingArea) {
}