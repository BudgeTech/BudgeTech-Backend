package br.sc.senac.budgetech.backend.dto.furniture;

public record FurnitureDTO(Long id,
                           String nameFurniture,
                           String description,
                           Double furnitureSize,
                           Double priceFurniture,
                           byte[] image,
                           Long idLivingArea) {}