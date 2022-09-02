package br.sc.senac.budgetech.backend.dto;

public record FurnitureDTO(Long id, String name, String description, double furnitureSize, double price,
                           Long idWoodwork, Long idLivingArea, Long idRequest, Long idItem) {
}