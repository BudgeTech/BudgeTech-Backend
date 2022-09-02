package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.ClientDTO;
import br.sc.senac.budgetech.backend.mapper.ClientMapper;
import br.sc.senac.budgetech.backend.projection.ClientBasicProjection;
import br.sc.senac.budgetech.backend.repository.AddressRepository;
import br.sc.senac.budgetech.backend.repository.ClientRepository;
import br.sc.senac.budgetech.backend.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public void update(ClientDTO clientDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ClientBasicProjection findById(Long id) {
        return null;
    }

    @Override
    public ClientBasicProjection findByName(String name) {
        return null;
    }

    @Override
    public ClientBasicProjection findByCpf(String cpf) {
        return null;
    }
}