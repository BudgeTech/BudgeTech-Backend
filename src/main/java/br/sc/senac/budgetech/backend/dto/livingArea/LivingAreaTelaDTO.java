package br.sc.senac.budgetech.backend.dto.livingArea;

import java.sql.Blob;

public record LivingAreaTelaDTO(String nameLivingArea,
                                Blob image) {}