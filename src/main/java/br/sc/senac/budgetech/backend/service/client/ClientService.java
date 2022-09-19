package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.projection.client.ClientListProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientProfileEditProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientProfileFullEditProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
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

    ClientProfileEditProjection findProfileEditById(Long id);

    ClientProjection findByContactPhoneNumber(String phoneNumber);

    ClientProfileFullEditProjection findProfileFullEditById(Long id);

    Page<ClientListProjection> findWithPaginationAndSortingByClientId(Pageable pageable, Integer page);

}