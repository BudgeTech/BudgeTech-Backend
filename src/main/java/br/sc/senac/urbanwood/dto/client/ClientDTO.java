package br.sc.senac.urbanwood.dto.client;

public record ClientDTO(String login,
                        String password,
                        Long id,
                        String nameClient,
                        String lastName,
                        String cpf,
                        Long idContact,
                        Long idAddress,
                        Long idImage) {


}