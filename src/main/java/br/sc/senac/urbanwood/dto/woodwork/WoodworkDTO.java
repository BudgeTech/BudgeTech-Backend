package br.sc.senac.urbanwood.dto.woodwork;

public record WoodworkDTO(String login,
                          String password,
                          Long idUser,
                          String companyName,
                          String cnpj,
                          String description,
                          Long idContact,
                          Long idAddress,
                          Long idImage) {
}