package br.sc.senac.urbanwood.repository.client;

import br.sc.senac.urbanwood.projection.furniture.screen.FurnitureProjectionC13;
import br.sc.senac.urbanwood.model.client.Client;
import br.sc.senac.urbanwood.projection.client.ClientProjection;
import br.sc.senac.urbanwood.projection.client.screen.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByLogin(String login);

    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientProjection> findClientByCpf(String cpf);

    List<ClientProjection> findClientByNameClient(String nameClient);

    //Screen

    @Query(value = """
            select c.id as id, i.picByte as picByte, c.nameClient as nameClient, c.lastName as lastName,
            a.neighborhood as neighborhood, a.city as city,
            co.phoneNumber as phoneNumber
            from Client c
            inner join Address a on c.id = a.id
            inner join Contact co on c.id = co.id
            inner join ImageModel i on c.id = i.id
            """)
    Page<ClientProjectionW9> findClientW9ByNameClient(Pageable pageable);

    Optional<ClientProjectionW10> findClientW10ById(Long id);

    @Query(value = """
            select c.nameClient as nameClient, c.cpf as cpf,
            co.email as email, co.phoneNumber as phoneNumber,
            a.street as street, a.neighborhood as neighborhood, a.cep as cep, a.number as number, a.city as city,
            i.quantity as quantity,
            img.picByte as picByte
            from Client c
            join Contact co on c.id = co.id
            join Address a on c.id = a.id
            join Item i on c.id = i.id
            join ImageModel img on c.id = img.id
            """)
    Optional<ClientProjectionC13> findClientC13ById(Long id);

    @Query(value = """
            select f.nameFurniture as nameFurniture, f.id as id, f.priceFurniture as priceFurniture
            from Furniture f
            join Order o on f.id = o.id
            """)
    List<FurnitureProjectionC13> findClientC13ByIdPart2(Long id);

    Optional<ClientProjectionC6> findClientC6ById(Long id);

    Optional<ClientProjectionC7> findClientC7ById(Long id);
}
