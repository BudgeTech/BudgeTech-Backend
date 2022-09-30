package br.sc.senac.urbanwood.dto.address;

public record AddressDTO(Long id,
                         String street,
                         Integer number,
                         String complement,
                         String neighborhood,
                         String city,
                         String province, String cep) {
}