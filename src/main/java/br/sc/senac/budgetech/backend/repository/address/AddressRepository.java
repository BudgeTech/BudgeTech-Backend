package br.sc.senac.budgetech.backend.repository.address;

import br.sc.senac.budgetech.backend.model.address.Address;
import br.sc.senac.budgetech.backend.projection.address.AddressProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    boolean existsByStreetAndNumber(String street, int number);

    Optional<AddressProjection> findAddressById(Long id);

    Optional<AddressProjection> findAddressByStreet(String street);

    Optional<AddressProjection> findAddressByNumber(int number);

    List<AddressProjection> findAddressByNeighborhood(String neighbor);
}
