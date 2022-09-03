package br.sc.senac.budgetech.backend.dto;

import java.sql.Blob;

public record WoodworkDTO(String login, String password, Blob image, Long id, String companyName, String cnpj, String description, Long idContact, Long idAddress) {}