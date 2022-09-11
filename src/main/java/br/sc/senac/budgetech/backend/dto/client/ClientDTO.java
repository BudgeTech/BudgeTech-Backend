package br.sc.senac.budgetech.backend.dto.client;

import java.sql.Blob;

public record ClientDTO(String login,
                        String password,
                        Blob image,
                        Long id,
                        String nameClient,
                        String lastName,
                        String cpf,
                        Long idContact,
                        Long idAddress) {}