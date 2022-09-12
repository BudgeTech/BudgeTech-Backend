package br.sc.senac.budgetech.backend.dto.furniture;

public record FurnitureDTO(Long id,
                           String nameFurniture,
                           String description,
                           double furnitureSize,
                           double priceFurniture,
                           Long idLivingArea) {}