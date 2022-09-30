package br.sc.senac.urbanwood.service.contact;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.exception.contact.ContactEmailRegisteredException;
import br.sc.senac.urbanwood.exception.contact.ContactNotFoundException;
import br.sc.senac.urbanwood.exception.contact.ContactPhoneNumberRegisteredException;
import br.sc.senac.urbanwood.mapper.contact.ContactMapper;
import br.sc.senac.urbanwood.model.contact.Contact;
import br.sc.senac.urbanwood.projection.contact.ContactProjection;
import br.sc.senac.urbanwood.repository.contact.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public ContactDTO save(ContactDTO contactDTO) {

        if (contactRepository.existsByEmail(contactDTO.email()))
            throw new ContactEmailRegisteredException("Email " + contactDTO.email() + " is already registered");

        if (contactRepository.existsByPhoneNumber(contactDTO.phoneNumber()))
            throw new ContactPhoneNumberRegisteredException("Phone Number " + contactDTO.phoneNumber() + " is already registered");

        Contact contact = contactMapper.toEntity(contactDTO);
        Contact contactSaved = contactRepository.save(contact);
        return contactMapper.toDTO(contactSaved);
    }

    public void update(ContactDTO contactDTO, Long id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found"));

        if (contactDTO.email().equals(contact.getEmail()) && contactDTO.phoneNumber().equals(contact.getPhoneNumber())) {
            contact.setEmail(contactDTO.email());
            contact.setPhoneNumber(contactDTO.phoneNumber());
            contact.setSocialNetwork(contactDTO.socialNetwork());
            return;
        }

        if (contactRepository.existsByEmail(contactDTO.email()))
            throw new ContactEmailRegisteredException("Email " + contactDTO.email() + " is already registered");

        if (contactRepository.existsByPhoneNumber(contactDTO.phoneNumber()))
            throw new ContactPhoneNumberRegisteredException("Phone Number " + contactDTO.phoneNumber() + " is already registered");

        contact.setEmail(contactDTO.email());
        contact.setPhoneNumber(contactDTO.phoneNumber());
        contact.setSocialNetwork(contactDTO.socialNetwork());
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

    public ContactProjection findByEmail(String email) {
        return contactRepository.findContactByEmail(email)
                .orElseThrow(() -> new ContactNotFoundException("Contact " + email + " was not found"));
    }

    public ContactProjection findByPhoneNumber(String phoneNumber) {
        return contactRepository.findContactByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ContactNotFoundException("Contact " + phoneNumber + " was not found"));
    }
}