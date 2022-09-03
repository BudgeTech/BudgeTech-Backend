package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.ClientDTO;
import br.sc.senac.budgetech.backend.projection.ClientProjection;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);

    void update(ClientDTO clientDTO, Long id);

    void delete(Long id);

    ClientProjection findById(Long id);

    ClientProjection findByName(String name);

    ClientProjection findByCpf(String cpf);
}