package br.sc.senac.budgetech.backend.dto.woodwork;

import java.sql.Blob;

public record WoodworkProfileEditDTO(String companyName, String cnpj, Blob image) {}