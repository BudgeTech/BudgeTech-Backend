package br.sc.senac.budgetech.backend.dto.livingArea;

public record LivingAreaDTO(Long id,
                            String nameLivingArea,
                            byte[] image,
                            Long idUser) {}