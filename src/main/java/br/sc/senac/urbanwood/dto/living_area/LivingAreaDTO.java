package br.sc.senac.urbanwood.dto.living_area;

public record LivingAreaDTO(Long id,
                            String nameLivingArea,
                            byte[] image,
                            Long idWoodwork) {
}