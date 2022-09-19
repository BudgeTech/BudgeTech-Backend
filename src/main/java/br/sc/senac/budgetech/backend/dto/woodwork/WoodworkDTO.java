package br.sc.senac.budgetech.backend.dto.woodwork;

public record WoodworkDTO(String login,
                          String password,
                          byte[] image,
                          Long idUser,
                          String companyName,
                          String cnpj,
                          String description,
                          Long idContact,
                          Long idAddress) {}