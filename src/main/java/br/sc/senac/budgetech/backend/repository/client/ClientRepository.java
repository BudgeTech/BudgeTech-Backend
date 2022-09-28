package br.sc.senac.budgetech.backend.repository.client;

import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.projection.client.ClientListProjectionW9;
import br.sc.senac.budgetech.backend.projection.client.ClientOrderProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientW10;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, CustomClientRepository {

    boolean existsByCpf(String cpf);

    boolean existsByLogin(String login);

    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientProjection> findClientByCpf(String cpf);

    Optional<ClientProjection> findClientByLogin(String login);

    List<ClientProjection> findClientByNameClient(String nameClient);

    Optional<ClientProjection> findClientByContactPhoneNumber(String phoneNumber);

    @Query(value = """
    select c.id as id, c.cpf as cpf, c.nameClient as nameClient, c.lastName as lastName,
    u.image as image,
    a.city as city, a.street as street, a.number as number, a.complement as complement, a.neighborhood as neighborhood, a.city as city, a.cep as cep,
    co.email as email, co.phoneNumber as phoneNumber, co.socialNetwork as socialNetwork
    from Client c
    inner join Address a on c.id = a.id
    inner join Contact co on c.id = co.id
    inner join User u on c.id = u.id
    where c.id = ?1
    """)
    ClientW10 findClientW10(Long id);

    @Query(value = """
            Select c.nameClient as nameClient, c.cpf as cpf,
            co.email as email, co.phoneNumber as phoneNumber,
            a.street as street, a.neighborhood as neighborhood, a.cep as cep,
            a.number as number, a.city as city
            from Client
            inner join Contact co on c.id = co.id
            inner join Address a on c.id = a.id
            where c.id = ?1
            """)
    ClientOrderProjection findByTest(Long id);

    @Query(value = "SELECT client_name as name, client_last_name as lastName from Client", nativeQuery = true)
    Page<ClientListProjectionW9> findAllClientBy(Pageable pageable);
}
