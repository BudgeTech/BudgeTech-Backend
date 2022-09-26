package br.sc.senac.urbanwood.backend.dto.livingArea;

import java.sql.Blob;

public record LivingAreaDTO(Long id, String nameLivingArea, Blob image, Long idWoodwork) {
}