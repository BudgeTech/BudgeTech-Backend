package br.sc.senac.urbanwood.service.client;

import br.sc.senac.urbanwood.dto.client.ClientDTO;
import br.sc.senac.urbanwood.projection.client.ClientProjection;
import br.sc.senac.urbanwood.projection.client.screen.*;
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

    //Screen

    Page<ClientProjectionW9> findW9ByNameClient(Pageable pageable, Integer page);

    ClientProjectionW10 findW10ById(Long id);

    ClientProjectionC13 findC13ById(Long id);

    ClientProjectionC6 findC6ById(Long id);

    ClientProjectionC7 findC7ById(Long id);
}