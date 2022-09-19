package br.sc.senac.budgetech.backend.dto.livingArea;

import java.sql.Blob;

public record LivingAreaDTO(Long id,
                            String nameLivingArea,
                            byte[] image,

                            Long idUser) {}