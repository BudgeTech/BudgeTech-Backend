package br.sc.senac.urbanwood.dto.contact;

public record ContactDTO(Long id,
                         String email,
                         String phoneNumber,
                         String socialNetwork) {
}