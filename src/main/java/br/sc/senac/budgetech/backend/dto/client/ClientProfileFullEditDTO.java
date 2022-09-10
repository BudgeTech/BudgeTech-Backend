package br.sc.senac.budgetech.backend.dto.client;

import java.sql.Blob;

public record ClientProfileFullEditDTO(String nameClient, String lastName, String cpf, Blob image, String street, int number,
                                       String complement, String neighbor, String city, String cep, String phoneNumber,
                                       String email, String socialNetwork) {
}
