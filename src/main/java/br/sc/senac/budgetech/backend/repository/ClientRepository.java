package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Client;
import br.sc.senac.budgetech.backend.projection.ClientWithAddressAndContactProjection;
import br.sc.senac.budgetech.backend.projection.ClientProjection;
import br.sc.senac.budgetech.backend.projection.ClientWithAll;
import br.sc.senac.budgetech.backend.projection.ClientWithItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByLogin(String login);

    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientProjection> findClientByName(String name);

    Optional<ClientProjection> findClientByCpf(String cpf);

    Optional<ClientProjection> findClientByLogin(String login);

    Optional<ClientProjection> findClientByContactPhoneNumber(String phoneNumber);

    Optional<ClientWithAddressAndContactProjection> findClientWithAddressAndContactById(Long id);

    Optional<ClientWithItemProjection> findClientWithItemById(Long id);

    Optional<ClientWithAll> findClientWithAddressAndContactAndItemById(Long id);
}
