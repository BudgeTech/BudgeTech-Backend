package br.sc.senac.budgetech.backend.service.address;

import br.sc.senac.budgetech.backend.dto.address.AddressDTO;
import br.sc.senac.budgetech.backend.exception.address.AddressInvalidException;
import br.sc.senac.budgetech.backend.exception.address.AddressNotFoundException;
import br.sc.senac.budgetech.backend.exception.address.AddressStreetAndNumberRegisteredException;
import br.sc.senac.budgetech.backend.mapper.address.AddressMapper;
import br.sc.senac.budgetech.backend.model.address.Address;
import br.sc.senac.budgetech.backend.projection.address.AddressProjection;
import br.sc.senac.budgetech.backend.repository.address.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressDTO save(AddressDTO addressDTO) {

        if (addressRepository.existsByStreetAndNumber(addressDTO.street(), addressDTO.number()))
            throw new AddressStreetAndNumberRegisteredException
                    ("Street " + addressDTO.street() + " and Number " + addressDTO.number() + " are already registered");

        Address address = addressMapper.toEntity(addressDTO);
        Address addressSaved = addressRepository.save(address);
        return addressMapper.toDTO(addressSaved);
    }


    public void update(AddressDTO addressDTO, Long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address " + id + " was not found"));

        if (addressRepository.existsByStreetAndNumber(addressDTO.street(), addressDTO.number()))
            throw new AddressStreetAndNumberRegisteredException
                    ("Road " + addressDTO.street() + " and Number " + addressDTO.number() + " are already registered");

        if (addressDTO.number() <= 0)
            throw new AddressInvalidException("Number " + addressDTO.number() + " is invalid");

        address.setCep(addressDTO.cep());
        address.setCity(addressDTO.city());
        address.setNumber(addressDTO.number());
        address.setStreet(addressDTO.street());
        address.setProvince(addressDTO.province());
        address.setComplement(addressDTO.complement());
        address.setNeighborhood(addressDTO.neighborhood());

        Optional<AddressProjection> existsStreet = addressRepository.findAddressByStreet(addressDTO.street());
        Optional<AddressProjection> existsNumber = addressRepository.findAddressByNumber(addressDTO.number());

        if (existsNumber.isPresent() && existsStreet.isPresent() && (existsNumber.get().getId().equals(id)))
            throw new AddressStreetAndNumberRegisteredException
                    ("Road " + addressDTO.street() + " and Number " + addressDTO.number() + " are already registered");

        addressRepository.save(address);
    }

    public void delete(Long id) {
        if (!addressRepository.existsById(id))
            throw new AddressNotFoundException("Address " + id + " was not found");
        addressRepository.deleteById(id);
    }

    public AddressProjection findById(Long id) {
        return addressRepository.findAddressById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address " + id + " was not found"));
    }

    public List<AddressProjection> findByNeighborhood(String neighborhood) {
        List<AddressProjection> address = addressRepository.findAddressByNeighborhood(neighborhood);
        if(address.isEmpty())
            throw new AddressNotFoundException("Address " + neighborhood + " was not found");
        return address;
    }
}