package br.sc.senac.urbanwood.mapper.contact;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.model.contact.Contact;
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
