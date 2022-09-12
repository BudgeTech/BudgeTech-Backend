package br.sc.senac.budgetech.backend.dto.woodwork;

import java.sql.Blob;

public record WoodworkProfileDTO(String companyName, String description, String cnpj, Blob image, String city, String province, String neighborhood,
                                 String phoneNumber, String email, String socialNetwork) {
}