package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Client;
import br.sc.senac.budgetech.backend.projection.ClientAllProjection;
import br.sc.senac.budgetech.backend.projection.ClientProjection;
import br.sc.senac.budgetech.backend.projection.WoodworkAllProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);

    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientProjection> findClientByName(String name);

    Optional<ClientProjection> findClientByCpf(String cpf);

    Optional<ClientProjection> findClientByContactPhoneNumber(String phoneNumber);

    Optional<ClientAllProjection> findClientWithAddressAndContactById(Long id);
}
