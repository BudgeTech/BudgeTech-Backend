package br.sc.senac.urbanwood.service.woodwork;

import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.exception.address.AddressNotFoundException;
import br.sc.senac.urbanwood.exception.client.ClientLoginRegisteredException;
import br.sc.senac.urbanwood.exception.contact.ContactNotFoundException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkCnpjInvalidException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkCnpjRegisteredException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.mapper.woodwork.WoodworkMapper;
import br.sc.senac.urbanwood.model.address.Address;
import br.sc.senac.urbanwood.model.contact.Contact;
import br.sc.senac.urbanwood.model.woodwork.Woodwork;
import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC8;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC9;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW6;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW7;
import br.sc.senac.urbanwood.repository.address.AddressRepository;
import br.sc.senac.urbanwood.repository.contact.ContactRepository;
import br.sc.senac.urbanwood.repository.woodwork.WoodworkRepository;
import br.sc.senac.urbanwood.util.CNPJValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoodworkServiceImpl implements WoodworkService {

    private final WoodworkRepository woodworkRepository;
    private final WoodworkMapper woodworkMapper;
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    public WoodworkServiceImpl(WoodworkRepository woodworkRepository, WoodworkMapper woodworkMapper, AddressRepository addressRepository, ContactRepository contactRepository) {
        this.woodworkRepository = woodworkRepository;
        this.woodworkMapper = woodworkMapper;
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    public WoodworkDTO save(WoodworkDTO woodworkDTO) {

        Contact contact = contactRepository.findById(woodworkDTO.idContact())
                .orElseThrow(() -> new ContactNotFoundException("Contact " + woodworkDTO.idContact() + " was not found"));

        Address address = addressRepository.findById(woodworkDTO.idAddress())
                .orElseThrow(() -> new AddressNotFoundException("Address " + woodworkDTO.idAddress() + " was not found"));

        if (woodworkRepository.existsByCnpj(woodworkDTO.cnpj()))
            throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cnpj() + " is already registered");

        if (woodworkRepository.existsByLogin(woodworkDTO.login()))
            throw new ClientLoginRegisteredException("Login " + woodworkDTO.login() + " is already registered");

        if (CNPJValidator.isCNPJ(woodworkDTO.cnpj()))
            throw new WoodworkCnpjInvalidException("Cnpj " + woodworkDTO.cnpj() + " is invalid");

        Woodwork woodwork = woodworkMapper.toEntity(woodworkDTO);
        woodwork.setContact(contact);
        woodwork.setAddress(address);
        Woodwork woodworkSaved = woodworkRepository.save(woodwork);
        return woodworkMapper.toDTO(woodworkSaved);
    }

    public void update(WoodworkDTO woodworkDTO, Long id) {

        Woodwork woodwork = woodworkRepository.findById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));

        if (CNPJValidator.isCNPJ(woodworkDTO.cnpj()))
            throw new WoodworkCnpjInvalidException("Cnpj " + woodworkDTO.cnpj() + " is invalid");

        if (woodworkDTO.cnpj().equals(woodwork.getCnpj()) && woodworkDTO.login().equals(woodwork.getLogin())) {
            woodwork.setCompanyName(woodworkDTO.companyName());
            woodwork.setDescription(woodworkDTO.description());
            woodwork.setCnpj(woodworkDTO.cnpj());
            woodwork.setLogin(woodworkDTO.login());
            woodwork.setPassword(woodworkDTO.password());
            woodwork.setImage(woodworkDTO.image());
            woodworkRepository.save(woodwork);
            return;
        }

        if (woodworkRepository.existsByCnpj(woodworkDTO.cnpj()))
            throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cnpj() + " is already registered");

        if (woodworkRepository.existsByLogin(woodworkDTO.login()))
            throw new ClientLoginRegisteredException("Login " + woodworkDTO.login() + " is already registered");

        woodwork.setCompanyName(woodworkDTO.companyName());
        woodwork.setDescription(woodworkDTO.description());
        woodwork.setCnpj(woodworkDTO.cnpj());
        woodwork.setLogin(woodworkDTO.login());
        woodwork.setPassword(woodworkDTO.password());
        woodwork.setImage(woodworkDTO.image());
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

    public List<WoodworkProjection> findByCompanyName(String companyName) {
        List<WoodworkProjection> woodwork = woodworkRepository.findWoodworkByCompanyName(companyName);

        if(woodwork.isEmpty())
            throw new WoodworkNotFoundException("Woodwork " + companyName + " was not found");
        return woodwork;
    }

    //Screen

    public WoodworkProjectionC8 findC8ById(Long id) {
        return woodworkRepository.findWoodworkC8ById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));
    }

    public List<WoodworkProjectionC9> findC9ByName(String companyName) {
        var woodwork = woodworkRepository.findWoodworkC9ByCompanyName(companyName);

        if (woodwork.isEmpty()) throw new WoodworkNotFoundException("Woodwork " + companyName + "was not found");
        return woodwork;
    }

    public WoodworkProjectionW6 findW6ById(Long id) {
        return woodworkRepository.findWoodworkW6ById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));
    }

    public WoodworkProjectionW7 findW7ById(Long id) {
        return woodworkRepository.findWoodworkW7ById(id)
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));
    }
}