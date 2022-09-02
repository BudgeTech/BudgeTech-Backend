package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    boolean existsByStreetAndNumber(String street, int number);

    Optional<Address> findAddressByCity(String city);

    Optional<Address> findAddressByNeighbor(String neighbor);
}
