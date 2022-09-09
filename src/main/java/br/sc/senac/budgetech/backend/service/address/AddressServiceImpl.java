package br.sc.senac.budgetech.backend.service.address;

import br.sc.senac.budgetech.backend.dto.AddressDTO;
import br.sc.senac.budgetech.backend.exception.address.AddressInvalidException;
import br.sc.senac.budgetech.backend.exception.address.AddressNotFoundException;
import br.sc.senac.budgetech.backend.exception.address.AddressStreetAndNumberRegisteredException;
import br.sc.senac.budgetech.backend.mapper.AddressMapper;
import br.sc.senac.budgetech.backend.model.Address;
import br.sc.senac.budgetech.backend.projection.AddressProjection;
import br.sc.senac.budgetech.backend.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

        if (addressRepository.existsByStreetAndNumber(addressDTO.street(), addressDTO.number()))
            throw new AddressStreetAndNumberRegisteredException
                    ("Road " + addressDTO.street() + " and Number " + addressDTO.number() + " are already registered");

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address " + id + " was not found"));

        if (addressDTO.number() <= 0)
            throw new AddressInvalidException("Number " + addressDTO.number() + " is invalid");

        address.setNumber(addressDTO.number());
        address.setProvince((addressDTO.province() != null && !addressDTO.province().isBlank()) ? addressDTO.province() : address.getProvince());
        address.setStreet((addressDTO.street() != null && !addressDTO.street().isBlank()) ? addressDTO.street() : address.getStreet());
        address.setNeighbor((addressDTO.neighbor() != null && !addressDTO.neighbor().isBlank()) ? addressDTO.neighbor() : address.getNeighbor());
        address.setCity((addressDTO.city() != null && !addressDTO.city().isBlank()) ? addressDTO.city() : address.getCity());
        address.setCep((addressDTO.cep() != null && !addressDTO.cep().isBlank()) ? addressDTO.cep() : address.getCep());
        address.setComplement((addressDTO.complement() != null && !addressDTO.complement().isBlank()) ? addressDTO.complement() : address.getComplement());

        var existsNumber = addressRepository.findAddressByStreet(addressDTO.street());
        var existsStreet = addressRepository.findAddressByNumber(addressDTO.number());

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

    public AddressProjection findByNeighbor(String neighbor) {
        return addressRepository.findAddressByNeighbor(neighbor)
                .orElseThrow(() -> new AddressNotFoundException("Address " + neighbor + " was not found"));
    }

    public AddressProjection findByCity(String city) {
        return addressRepository.findAddressByCity(city)
                .orElseThrow(() -> new AddressNotFoundException("Address " + city + " was not found"));
    }
}