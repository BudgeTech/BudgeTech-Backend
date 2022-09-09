package br.sc.senac.budgetech.backend.service.contact;

import br.sc.senac.budgetech.backend.dto.contact.ContactDTO;
import br.sc.senac.budgetech.backend.exception.client.ClientCpfRegisteredException;
import br.sc.senac.budgetech.backend.exception.contact.ContactNotFoundException;
import br.sc.senac.budgetech.backend.mapper.ContactMapper;
import br.sc.senac.budgetech.backend.model.Contact;
import br.sc.senac.budgetech.backend.projection.contact.ContactProjection;
import br.sc.senac.budgetech.backend.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private ContactMapper contactMapper;

    public ContactDTO save(ContactDTO contactDTO) {

        if (contactRepository.existsByEmail(contactDTO.email()))
            throw new ClientCpfRegisteredException("Email " + contactDTO.email() + " is already registered");

        if (contactRepository.existsByPhoneNumber(contactDTO.phoneNumber()))
            throw new ClientCpfRegisteredException("Phone Number " + contactDTO.phoneNumber() + " is already registered");

        Contact contact = contactMapper.toEntity(contactDTO);
        Contact contactSaved = contactRepository.save(contact);
        return contactMapper.toDTO(contactSaved);

    }

    public void update(ContactDTO contactDTO, Long id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found"));

        if (contactRepository.existsByEmail(contactDTO.email()))
            throw new ClientCpfRegisteredException("Email " + contactDTO.email() + " is already registered");

        if (contactRepository.existsByPhoneNumber(contactDTO.phoneNumber()))
            throw new ClientCpfRegisteredException("Phone Number " + contactDTO.phoneNumber() + " is already registered");

        contact.setPhoneNumber((contactDTO.phoneNumber() != null && !contactDTO.phoneNumber().isBlank()) ? contactDTO.phoneNumber() : contact.getPhoneNumber());
        contact.setEmail((contactDTO.email() != null && !contactDTO.email().isBlank()) ? contactDTO.email() : contact.getEmail());
        contact.setSocialNetwork((contactDTO.socialNetwork() != null && !contactDTO.socialNetwork().isBlank()) ? contactDTO.socialNetwork() : contact.getSocialNetwork());

        contactRepository.save(contact);
    }

    public void delete(Long id) {
        if (!contactRepository.existsById(id))
            throw new ContactNotFoundException("Contact " + id + " was not found");
        contactRepository.deleteById(id);
    }

    public ContactProjection findById(Long id) {
        return contactRepository.findContactById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found"));
    }

    public ContactProjection findByPhoneNumber(String phoneNumber) {
        return contactRepository.findContactByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ContactNotFoundException("Contact " + phoneNumber + " was not found"));
    }
}