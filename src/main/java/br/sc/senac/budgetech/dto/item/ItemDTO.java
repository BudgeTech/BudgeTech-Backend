package br.sc.senac.budgetech.dto.item;

public record ItemDTO(Long id,
                      Integer quantity,
                      Double totalPrice,
                      Long idOrder,
                      Long idClient,
                      Long idWoodwork) {
}