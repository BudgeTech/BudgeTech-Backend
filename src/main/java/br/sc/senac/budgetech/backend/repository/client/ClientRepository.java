package br.sc.senac.budgetech.backend.repository.client;

import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.projection.client.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByLogin(String login);

    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientProjection> findClientByCpf(String cpf);

    Optional<ClientProjection> findClientByLogin(String login);

    Optional<ClientProjection> findClientByNameClient(String nameClient);

    Optional<ClientProjection> findClientByContactPhoneNumber(String phoneNumber);

    Optional<ClientProfileEditProjection> findClientProfileEditById(Long id);

    Optional<ClientProfileFullEditProjection> findClientProfileFullEditById(Long id);
}
