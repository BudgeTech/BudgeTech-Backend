package br.sc.senac.budgetech.backend.dto.client;

import java.sql.Blob;

public record ClientProfileEditDTO(String nameClient,
                                   String lastName,
                                   String cpf,
                                   Blob image) {}
