package br.sc.senac.budgetech.backend.service.address;


import br.sc.senac.budgetech.backend.dto.AddressDTO;
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

        address.setStreet(addressDTO.street());
        address.setNumber(addressDTO.number());
        address.setNeighbor(addressDTO.neighbor());
        address.setCity(addressDTO.city());
        address.setCep(addressDTO.cep());
        address.setComplement(addressDTO.complement());

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