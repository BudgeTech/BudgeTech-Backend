package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Client;
import br.sc.senac.budgetech.backend.projection.ClientBasicProjection;
import br.sc.senac.budgetech.backend.projection.ClientProfileProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);

    Optional<ClientBasicProjection> findClientById(Long id);

    Optional<ClientBasicProjection> findClientByName(String name);

    Optional<ClientProfileProjection> findClientByCpf(String cpf);
}
