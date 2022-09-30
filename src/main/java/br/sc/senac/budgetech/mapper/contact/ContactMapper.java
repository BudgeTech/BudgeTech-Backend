package br.sc.senac.budgetech.mapper.contact;

import br.sc.senac.budgetech.dto.contact.ContactDTO;
import br.sc.senac.budgetech.model.contact.Contact;
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
