package br.sc.senac.urbanwood.dto.woodwork;

public record WoodworkDTO(String login,
                          String password,
                          byte[] image,
                          Long idUser,
                          String companyName,
                          String cnpj,
                          String description,
                          Long idContact,
                          Long idAddress) {
}