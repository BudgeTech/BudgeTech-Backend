package br.sc.senac.budgetech.backend.dto.furniture;

import java.sql.Blob;

public record FurnitureDTO(Long id, String name, String description, double furnitureSize, double price,
                           Long idLivingArea) {
}