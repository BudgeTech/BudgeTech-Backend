package br.sc.senac.urbanwood.backend.mapper;

import br.sc.senac.urbanwood.backend.dto.address.AddressDTO;
import br.sc.senac.urbanwood.backend.model.Address;

import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public AddressDTO toDTO(Address address) {
        return new AddressDTO(address.getId(), address.getStreet(), address.getNumber(), address.getComplement(), address.getNeighbor(), address.getCity(), address.getProvince(), address.getCep());
    }

    public Address toEntity(AddressDTO dto) {
        return new Address(dto.id(), dto.street(), dto.number(), dto.complement(), dto.neighbor(), dto.city(), dto.province(), dto.cep());
    }
}
