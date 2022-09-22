package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.projection.client.ClientListProjectionW9;
import br.sc.senac.budgetech.backend.projection.client.ClientProfileFullEditProjectionW10;
import br.sc.senac.budgetech.backend.projection.client.ClientProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    ClientProfileFullEditProjectionW10 findProfileFullEditBy();

    Page<ClientListProjectionW9> findWithPaginationAndSortingByClientId(Pageable pageable, Integer page);

    //ClientProfileEditProjection findProfileEditById(Long id);
}