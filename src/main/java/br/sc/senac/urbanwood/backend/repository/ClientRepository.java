package br.sc.senac.urbanwood.backend.repository;

import br.sc.senac.urbanwood.backend.model.Client;
import br.sc.senac.urbanwood.backend.projection.client.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByLogin(String login);

    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientProjection> findClientByNameClient(String nameClient);

    Optional<ClientProjection> findClientByCpf(String cpf);

    Optional<ClientProjection> findClientByLogin(String login);

    Optional<ClientProjection> findClientByContactPhoneNumber(String phoneNumber);

    Optional<ClientWithAddressAndContactProjection> findClientWithAddressAndContactById(Long id);

    Optional<ClientWithItemProjection> findClientWithItemById(Long id);

    Optional<ClientWithAllProjection> findClientWithAddressAndContactAndItemById(Long id);

    //DTOS  ||
    //      ||
    //      vv

    Optional<ClientProfileEditProjection> findClientProfileEditById(Long id);

    Optional<ClientProfileFullEditProjection> findClientProfileFullEditById(Long id);
}
