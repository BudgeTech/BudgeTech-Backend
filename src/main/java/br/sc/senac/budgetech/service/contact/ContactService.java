package br.sc.senac.budgetech.service.contact;

import br.sc.senac.budgetech.dto.contact.ContactDTO;
import br.sc.senac.budgetech.projection.contact.ContactProjection;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {

    ContactDTO save(ContactDTO contactDTO);

    void update(ContactDTO contactDTO, Long id);

    void delete(Long id);

    ContactProjection findById(Long id);

    ContactProjection findByEmail(String email);

    ContactProjection findByPhoneNumber(String phoneNumber);
}