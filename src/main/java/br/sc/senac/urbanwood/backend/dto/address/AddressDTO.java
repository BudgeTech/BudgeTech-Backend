package br.sc.senac.urbanwood.backend.dto.address;

public record AddressDTO(Long id, String street, int number, String complement, String neighbor, String city,
                         String province, String cep) {
}