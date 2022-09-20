package br.sc.senac.budgetech.backend.service.contact;

import br.sc.senac.budgetech.backend.dto.contact.ContactDTO;
import br.sc.senac.budgetech.backend.exception.client.ClientCpfRegisteredException;
import br.sc.senac.budgetech.backend.exception.contact.ContactEmailInvalidException;
import br.sc.senac.budgetech.backend.exception.contact.ContactEmailRegisteredException;
import br.sc.senac.budgetech.backend.exception.contact.ContactNotFoundException;
import br.sc.senac.budgetech.backend.exception.contact.ContactPhoneNumberRegisteredException;
import br.sc.senac.budgetech.backend.mapper.contact.ContactMapper;
import br.sc.senac.budgetech.backend.model.contact.Contact;
import br.sc.senac.budgetech.backend.projection.contact.ContactProjection;
import br.sc.senac.budgetech.backend.repository.contact.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private ContactMapper contactMapper;
    private static final String regex = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";

    public ContactDTO save(ContactDTO contactDTO) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contactDTO.email());

        if (!matcher.matches()) throw new ContactEmailRegisteredException("email invalid");

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

        if (contactRepository.existsByEmail(contactDTO.email()))
            throw new ContactEmailRegisteredException("Email " + contactDTO.email() + " is already registered");

        if (contactRepository.existsByPhoneNumber(contactDTO.phoneNumber()))
            throw new ContactPhoneNumberRegisteredException("Phone Number " + contactDTO.phoneNumber() + " is already registered");

        contact.setPhoneNumber((contactDTO.phoneNumber() != null && !contactDTO.phoneNumber().isBlank()) ? contactDTO.phoneNumber() : contact.getPhoneNumber());
        contact.setEmail((contactDTO.email() != null && !contactDTO.email().isBlank()) ? contactDTO.email() : contact.getEmail());
        contact.setSocialNetwork((contactDTO.socialNetwork() != null && !contactDTO.socialNetwork().isBlank()) ? contactDTO.socialNetwork() : contact.getSocialNetwork());

        if (!contactDTO.email().isBlank()) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(contactDTO.email());
            if (!matcher.matches()) throw new ContactEmailInvalidException("Email " + contactDTO.email() + " invalid");
        }
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