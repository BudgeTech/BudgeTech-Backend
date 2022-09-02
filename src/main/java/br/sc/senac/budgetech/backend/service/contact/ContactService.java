package br.sc.senac.budgetech.backend.service.contact;

import br.sc.senac.budgetech.backend.dto.ContactDTO;
import br.sc.senac.budgetech.backend.model.Contact;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {

    ContactDTO save(ContactDTO contactDTO);

    void update(ContactDTO contactDTO, Long id);

    void delete(Long id);

    Contact findById(Long id);

    Contact findByPhoneNumber(String phoneNumber);
}