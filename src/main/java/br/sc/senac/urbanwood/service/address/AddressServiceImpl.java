package br.sc.senac.urbanwood.service.address;

import br.sc.senac.urbanwood.dto.address.AddressDTO;
import br.sc.senac.urbanwood.exception.address.AddressInvalidException;
import br.sc.senac.urbanwood.exception.address.AddressNotFoundException;
import br.sc.senac.urbanwood.exception.address.AddressStreetAndNumberRegisteredException;
import br.sc.senac.urbanwood.mapper.address.AddressMapper;
import br.sc.senac.urbanwood.model.address.Address;
import br.sc.senac.urbanwood.projection.address.AddressProjection;
import br.sc.senac.urbanwood.repository.address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public AddressDTO save(AddressDTO addressDTO) {

        if (addressRepository.existsByStreetAndNumber(addressDTO.street(), addressDTO.number()))
            throw new AddressStreetAndNumberRegisteredException
                    ("Street " + addressDTO.street() + " and Number " + addressDTO.number() + " are already registered");

        if (addressDTO.number() <= 0)
            throw new AddressInvalidException("Number " + addressDTO.number() + " is invalid");

        Address address = addressMapper.toEntity(addressDTO);
        Address addressSaved = addressRepository.save(address);
        return addressMapper.toDTO(addressSaved);
    }

    public void update(AddressDTO addressDTO, Long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address " + id + " was not found"));

        if (addressDTO.number() <= 0)
            throw new AddressInvalidException("Number " + addressDTO.number() + " is invalid");

        if (addressDTO.street().equals(address.getStreet()) && addressDTO.number().equals(address.getNumber())) {
            address.setCep(addressDTO.cep());
            address.setCity(addressDTO.city());
            address.setNumber(addressDTO.number());
            address.setStreet(addressDTO.street());
            address.setProvince(addressDTO.province());
            address.setComplement(addressDTO.complement());
            address.setNeighborhood(addressDTO.neighborhood());
            addressRepository.save(address);
            return;
        }

        if (addressRepository.existsByStreetAndNumber(addressDTO.street(), addressDTO.number()))
            throw new AddressStreetAndNumberRegisteredException
                    ("Road " + addressDTO.street() + " and Number " + addressDTO.number() + " are already registered");

        address.setCep(addressDTO.cep());
        address.setCity(addressDTO.city());
        address.setNumber(addressDTO.number());
        address.setStreet(addressDTO.street());
        address.setProvince(addressDTO.province());
        address.setComplement(addressDTO.complement());
        address.setNeighborhood(addressDTO.neighborhood());
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