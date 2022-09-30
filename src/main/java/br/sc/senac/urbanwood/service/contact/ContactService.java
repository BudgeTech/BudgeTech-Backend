package br.sc.senac.urbanwood.service.contact;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.projection.contact.ContactProjection;
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