package br.sc.senac.budgetech.dto.living_area;

public record LivingAreaDTO(Long id,
                            String nameLivingArea,
                            byte[] image,
                            Long idWoodwork) {
}