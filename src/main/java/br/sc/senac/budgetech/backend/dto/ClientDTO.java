package br.sc.senac.budgetech.backend.dto;

import java.sql.Blob;

public record ClientDTO(String login, String password, Blob image, Long id, String name, String lastName, String cpf, Long idContact, Long idAddress) {}