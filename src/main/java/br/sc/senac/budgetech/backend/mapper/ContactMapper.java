package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.ContactDTO;
import br.sc.senac.budgetech.backend.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactMapper {

    public ContactDTO toDTO(Contact contact) {
        return new ContactDTO(contact.getId(), contact.getEmail(), contact.getPhoneNumber(), contact.getSocialNetwork());
    }

    public Contact toEntity(ContactDTO dto) {
        return new Contact(dto.id(), dto.email(), dto.phoneNumber(), dto.socialNetwork());
    }
}
