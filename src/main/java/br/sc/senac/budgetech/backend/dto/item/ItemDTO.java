package br.sc.senac.budgetech.backend.dto.item;

public record ItemDTO(Long id, int quantity, double totalPrice, Long idRequest, Long idClient, Long idWoodwork) {}
