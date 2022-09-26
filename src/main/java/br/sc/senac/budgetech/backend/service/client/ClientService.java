package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.projection.client.ClientListProjectionW9;
import br.sc.senac.budgetech.backend.projection.client.ClientListW10;
import br.sc.senac.budgetech.backend.projection.client.ClientProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);

    void update(ClientDTO clientDTO, Long id);

    void delete(Long id);

    ClientProjection findById(Long id);

    ClientProjection findByCpf(String cpf);

    List<ClientProjection> findByNameClient(String nameClient);

    ClientProjection findByContactPhoneNumber(String phoneNumber);

    ClientListW10 findProfileFullEditBy(Long id);

    Page<ClientListProjectionW9> findWithPaginationAndSortingByClientId(Pageable pageable, Integer page);
}