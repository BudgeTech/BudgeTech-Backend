package br.sc.senac.budgetech.backend.dto.woodwork;

public record WoodworkProfileFullEditDTO(String companyName, String cnpj, String street, int number, String complement,
                                         String neighbor, String city, String cep, String phoneNumber, String email,
                                         String socialNetwork) {
}
