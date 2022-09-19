package br.sc.senac.budgetech.backend.dto.woodwork;

import java.sql.Blob;

public record WoodworkDTO(String login, String password, Blob image, Long idUser, String companyName, String cnpj,
                          String description, Long idContact, Long idAddress) {
}