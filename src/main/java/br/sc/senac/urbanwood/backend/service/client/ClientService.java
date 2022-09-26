package br.sc.senac.urbanwood.backend.service.client;

import br.sc.senac.urbanwood.backend.dto.client.ClientDTO;
import br.sc.senac.urbanwood.backend.dto.client.ClientProfileEditDTO;
import br.sc.senac.urbanwood.backend.dto.client.ClientProfileFullEditDTO;
import br.sc.senac.urbanwood.backend.projection.client.ClientProjection;
import br.sc.senac.urbanwood.backend.projection.client.ClientWithAddressAndContactProjection;
import br.sc.senac.urbanwood.backend.projection.client.ClientWithAllProjection;
import br.sc.senac.urbanwood.backend.projection.client.ClientWithItemProjection;

import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);

    void update(ClientDTO clientDTO, Long id);

    void delete(Long id);

    ClientProjection findById(Long id);

    ClientProfileEditDTO findProfileEditById(Long id);

    ClientProfileFullEditDTO findProfileFullEditById(Long id);

    ClientProjection findByNameClient(String nameClient);

    ClientProjection findByCpf(String cpf);

    ClientProjection findByContactPhoneNumber(String phoneNumber);

    ClientWithAddressAndContactProjection findWithAddressAndContactById(Long id);

    ClientWithItemProjection findWithItemById(Long id);

    ClientWithAllProjection findWithAddressAndContactAndItemById(Long id);
}