package br.sc.senac.budgetech.backend.service.woodwork;

import br.sc.senac.budgetech.backend.dto.WoodworkDTO;
import br.sc.senac.budgetech.backend.exception.address.AddressNotFoundException;
import br.sc.senac.budgetech.backend.exception.contact.ContactNotFoundException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkCnpjRegisteredException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.budgetech.backend.mapper.WoodworkMapper;
import br.sc.senac.budgetech.backend.model.Address;
import br.sc.senac.budgetech.backend.model.Contact;
import br.sc.senac.budgetech.backend.model.Woodwork;
import br.sc.senac.budgetech.backend.projection.WoodworkProjection;
import br.sc.senac.budgetech.backend.repository.AddressRepository;
import br.sc.senac.budgetech.backend.repository.ContactRepository;
import br.sc.senac.budgetech.backend.repository.WoodworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

        if (woodworkRepository.existsByCnpj(woodworkDTO.cnpj()))
            throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cnpj() + " is already registered");

        Contact contact = contactRepository.findById(woodworkDTO.idContact())
                .orElseThrow(() -> new ContactNotFoundException("Contact " + woodworkDTO.idContact() + " was not found"));

        Address address = addressRepository.findById(woodworkDTO.idAddress())
                .orElseThrow(() -> new AddressNotFoundException("Address " + woodworkDTO.idAddress() + " was not found"));

        woodwork.setAddress(address);
        woodwork.setContact(contact);
        woodwork.setCompanyName(woodworkDTO.companyName());
        woodwork.setDescription(woodworkDTO.description());
        woodwork.setImage(woodworkDTO.image());
        woodwork.setCnpj(woodworkDTO.cnpj());
        woodwork.setLogin(woodworkDTO.login());
        woodwork.setPassword(woodworkDTO.password());
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

    public WoodworkProjection findByLogin(String login) {
        return woodworkRepository.findWoodworkByLogin(login)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + login + " was not found"));
    }
}