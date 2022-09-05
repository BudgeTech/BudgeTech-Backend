package br.sc.senac.budgetech.backend.dto;

public record AddressDTO(Long id, String street, int number, String complement, String neighbor, String city,
                         String province, String cep) {
}