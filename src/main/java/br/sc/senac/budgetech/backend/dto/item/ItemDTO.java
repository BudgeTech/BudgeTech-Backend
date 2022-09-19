package br.sc.senac.budgetech.backend.dto.item;

public record ItemDTO(Long id,
                      int quantity,
                      Double totalPrice,
                      Long idOrder,
                      Long idClient,
                      Long idWoodwork) {}