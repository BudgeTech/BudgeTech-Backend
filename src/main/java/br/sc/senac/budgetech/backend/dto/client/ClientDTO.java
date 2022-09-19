package br.sc.senac.budgetech.backend.dto.client;

import java.sql.Blob;

public record ClientDTO(String login,
                        String password,
                        byte[] image,
                        Long id,
                        String nameClient,
                        String lastName,
                        String cpf,
                        Long idContact,
                        Long idAddress) {}