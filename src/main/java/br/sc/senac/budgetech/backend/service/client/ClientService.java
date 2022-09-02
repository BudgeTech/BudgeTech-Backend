package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.ClientDTO;
import br.sc.senac.budgetech.backend.projection.ClientBasicProjection;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);

    void update(ClientDTO clientDTO, Long id);

    void delete(Long id);

    ClientBasicProjection findById(Long id);

    ClientBasicProjection findByName(String name);

    ClientBasicProjection findByCpf(String cpf);
}