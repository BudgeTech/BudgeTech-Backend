package br.sc.senac.budgetech.backend.service.woodwork;

import br.sc.senac.budgetech.backend.dto.woodwork.*;
import br.sc.senac.budgetech.backend.exception.address.AddressNotFoundException;
import br.sc.senac.budgetech.backend.exception.client.ClientLoginRegisteredException;
import br.sc.senac.budgetech.backend.exception.contact.ContactNotFoundException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkCnpjRegisteredException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkLoginRegisteredException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.budgetech.backend.mapper.WoodworkMapper;
import br.sc.senac.budgetech.backend.model.Address;
import br.sc.senac.budgetech.backend.model.Contact;
import br.sc.senac.budgetech.backend.model.Woodwork;
import br.sc.senac.budgetech.backend.projection.woodwork.*;
import br.sc.senac.budgetech.backend.repository.AddressRepository;
import br.sc.senac.budgetech.backend.repository.ContactRepository;
import br.sc.senac.budgetech.backend.repository.WoodworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WoodworkServiceImpl implements WoodworkService {

    private final WoodworkRepository woodworkRepository;
    private final WoodworkMapper woodworkMapper;
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    public WoodworkDTO save(WoodworkDTO woodworkDTO) {

        if (woodworkRepository.existsByCnpj(woodworkDTO.cnpj()))
            throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cnpj() + " is already registered");

        if (woodworkRepository.existsByLogin(woodworkDTO.login()))
            throw new ClientLoginRegisteredException("Login " + woodworkDTO.login() + " is already registered");

        Contact contact = contactRepository.findById(woodworkDTO.idContact())
                .orElseThrow(() -> new ContactNotFoundException("Contact " + woodworkDTO.idContact() + " was not found"));

        Address address = addressRepository.findById(woodworkDTO.idAddress())
                .orElseThrow(() -> new AddressNotFoundException("Address " + woodworkDTO.idAddress() + " was not found"));

        Woodwork woodwork = woodworkMapper.toEntity(woodworkDTO);
        woodwork.setContact(contact);
        woodwork.setAddress(address);
        Woodwork woodworkSaved = woodworkRepository.save(woodwork);
        return woodworkMapper.toDTO(woodworkSaved);
    }

    public void update(WoodworkDTO woodworkDTO, Long id) {

        Woodwork woodwork = woodworkRepository.findById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));

        Contact contact = contactRepository.findById(woodworkDTO.idContact())
                .orElseThrow(() -> new ContactNotFoundException("Contact " + woodworkDTO.idContact() + " was not found"));

        Address address = addressRepository.findById(woodworkDTO.idAddress())
                .orElseThrow(() -> new AddressNotFoundException("Address " + woodworkDTO.idAddress() + " was not found"));

        if (woodworkRepository.existsByCnpj(woodworkDTO.cnpj()))
            throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cnpj() + " is already registered");

        woodwork.setCompanyName((woodworkDTO.companyName() != null && !woodworkDTO.companyName().isBlank()) ? woodworkDTO.companyName() : woodwork.getCompanyName());
        woodwork.setDescription((woodworkDTO.description() != null && !woodworkDTO.description().isBlank()) ? woodworkDTO.description() : woodwork.getDescription());
        woodwork.setCnpj((woodworkDTO.cnpj() != null && !woodworkDTO.cnpj().isBlank()) ? woodworkDTO.cnpj() : woodwork.getCnpj());
        woodwork.setLogin((woodworkDTO.login() != null && !woodworkDTO.login().isBlank()) ? woodworkDTO.login() : woodwork.getLogin());
        woodwork.setPassword((woodworkDTO.password() != null && !woodworkDTO.password().isBlank()) ? woodworkDTO.password() : woodwork.getPassword());
        woodwork.setImage(woodworkDTO.image());
        woodwork.setContact(contact);
        woodwork.setAddress(address);

        Optional<WoodworkProjection> existsCnpj = woodworkRepository.findWoodworkByCnpj(woodworkDTO.cnpj());
        Optional<WoodworkProjection> existsLogin = woodworkRepository.findWoodworkByLogin(woodworkDTO.login());

        if (existsCnpj.isPresent() && (existsCnpj.get().getId().equals(id)))
            throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cnpj() + " is already registered");

        if (existsLogin.isPresent() && (existsLogin.get().getId().equals(id)))
            throw new WoodworkLoginRegisteredException("Login " + woodworkDTO.login() + " is already registered");

        woodworkRepository.save(woodwork);
    }

    public void delete(Long id) {
        if (!woodworkRepository.existsById(id))
            throw new WoodworkNotFoundException("Woodwork " + id + " was not found");
        woodworkRepository.deleteById(id);
    }

    public WoodworkProjection findById(Long id) {
        return woodworkRepository.findWoodworkById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));
    }

    public WoodworkProjection findByCnpj(String cnpj) {
        return woodworkRepository.findWoodworkByCnpj(cnpj)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + cnpj + " was not found"));
    }

    public WoodworkProjection findByCompanyName(String companyName) {
        return woodworkRepository.findWoodworkByCompanyName(companyName)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + companyName + " was not found"));
    }

    public WoodworkProjection findByAddressNeighborhood(String neighborhood) {
        return woodworkRepository.findWoodworkByAddressNeighborhood(neighborhood)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + neighborhood + " was not found"));
    }

    public WoodworkProjection findByContactPhoneNumber(String phoneNumber) {
        return woodworkRepository.findWoodworkByContactPhoneNumber(phoneNumber)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + phoneNumber + " was not found"));
    }

    public WoodworkProfileDTO findProfileById(Long id) {
        WoodworkProfileProjection woodwork = woodworkRepository.findWoodworkProfileById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));
        return woodworkMapper.toDTO(woodwork);
    }

    public WoodworkProfileEditDTO findProfileEditById(Long id) {
        WoodworkProfileEditProjection woodwork = woodworkRepository.findWoodworkProfileEditById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));
        return woodworkMapper.toDTO(woodwork);
    }

    public WoodworkProfileFullEditDTO findProfileFullEditById(Long id) {
        WoodworkProfileFullEditProjection woodwork = woodworkRepository.findWoodworkProfileFullEditById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));
        return woodworkMapper.toDTO(woodwork);
    }

    public WoodworkSearchDTO findSearchById(Long id) {
        List<WoodworkSearchProjection> woodwork = woodworkRepository.findWoodworkSearchById(id);
        if(woodwork.isEmpty())
            throw new WoodworkNotFoundException("Woodwork " + id + " was not found");
        return woodworkMapper.toDTO(woodwork);
    }
}