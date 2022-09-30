package br.sc.senac.budgetech.mapper.address;

import br.sc.senac.budgetech.dto.address.AddressDTO;
import br.sc.senac.budgetech.model.address.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public AddressDTO toDTO(Address address) {
        return new AddressDTO(address.getId(), address.getStreet(), address.getNumber(), address.getComplement(), address.getNeighborhood(), address.getCity(), address.getProvince(), address.getCep());
    }

    public Address toEntity(AddressDTO dto) {
        return new Address(dto.id(), dto.street(), dto.number(), dto.complement(), dto.neighborhood(), dto.city(), dto.province(), dto.cep());
    }
}
