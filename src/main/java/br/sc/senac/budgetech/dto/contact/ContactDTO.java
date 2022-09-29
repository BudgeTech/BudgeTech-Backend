package br.sc.senac.budgetech.dto.contact;

public record ContactDTO(Long id,
                         String email,
                         String phoneNumber,
                         String socialNetwork) {
}