package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Address;
import br.sc.senac.budgetech.backend.projection.AddressProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    boolean existsByStreetAndNumber(String street, int number);

    boolean existsByStreet(String street);

    boolean existsByNumber(int number);

    Optional<AddressProjection> findAddressById(Long id);

    Optional<AddressProjection> findAddressByStreet(String street);

    Optional<AddressProjection> findAddressByNumber(int number);

    Optional<AddressProjection> findAddressByCity(String city);

    Optional<AddressProjection> findAddressByNeighbor(String neighbor);
}
