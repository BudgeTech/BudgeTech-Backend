package br.sc.senac.budgetech.backend.dto.woodwork;

public record WoodworkProfileDTO(String companyName, String description, String city, String province, String neighborhood,
                                 String phoneNumber, String cnpj, String email, String socialNetwork) {
}