package br.sc.senac.budgetech.backend.dto.address;

public record AddressDTO(Long id,
                         String street,
                         int number,
                         String complement,
                         String neighborhood,
                         String city,
                         String province, String cep) {}