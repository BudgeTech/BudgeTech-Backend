package br.sc.senac.urbanwood.backend.dto.item;

public record ItemDTO(Long id, int quantity, double totalPrice, Long idRequest, Long idClient, Long idWoodwork) {}
