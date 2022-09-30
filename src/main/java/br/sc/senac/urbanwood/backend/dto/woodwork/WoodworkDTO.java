package br.sc.senac.urbanwood.backend.dto.woodwork;

import java.sql.Blob;

public record WoodworkDTO(String login, String password, Blob image, Long id, String companyName, String cnpj,
                          String description, Long idContact, Long idAddress) {
}