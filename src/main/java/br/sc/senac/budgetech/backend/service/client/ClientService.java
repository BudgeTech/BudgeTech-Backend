package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.dto.client.ClientProfileEditDTO;
import br.sc.senac.budgetech.backend.dto.client.ClientProfileFullEditDTO;
import br.sc.senac.budgetech.backend.projection.client.ClientProjection;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);

    void update(ClientDTO clientDTO, Long id);

    void delete(Long id);

    ClientProjection findById(Long id);

    ClientProjection findByCpf(String cpf);

    ClientProjection findByNameClient(String nameClient);

    ClientProjection findByContactPhoneNumber(String phoneNumber);

    ClientProfileEditDTO findProfileEditById(Long id);

    ClientProfileFullEditDTO findProfileFullEditById(Long id);
}