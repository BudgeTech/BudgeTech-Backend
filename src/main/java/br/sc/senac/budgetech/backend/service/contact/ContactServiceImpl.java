package br.sc.senac.budgetech.backend.service.contact;

import br.sc.senac.budgetech.backend.dto.ContactDTO;
import br.sc.senac.budgetech.backend.mapper.ContactMapper;
import br.sc.senac.budgetech.backend.model.Contact;
import br.sc.senac.budgetech.backend.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private ContactMapper contactMapper;

    @Override
    public ContactDTO save(ContactDTO contactDTO) {
        return null;
    }

    @Override
    public void update(ContactDTO contactDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Contact findById(Long id) {
        return null;
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        return null;
    }
}