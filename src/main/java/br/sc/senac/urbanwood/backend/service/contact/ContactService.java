package br.sc.senac.urbanwood.backend.service.contact;

import br.sc.senac.urbanwood.backend.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.backend.projection.contact.ContactProjection;

import org.springframework.stereotype.Service;

@Service
public interface ContactService {

    ContactDTO save(ContactDTO contactDTO);

    void update(ContactDTO contactDTO, Long id);

    void delete(Long id);

    ContactProjection findById(Long id);

    ContactProjection findByPhoneNumber(String phoneNumber);
}