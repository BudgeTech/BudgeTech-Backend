package br.sc.senac.budgetech.repository.address;

import br.sc.senac.budgetech.model.address.Address;
import br.sc.senac.budgetech.projection.address.AddressProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<AddressProjection> findAddressById(Long id);

    List<AddressProjection> findAddressByNeighborhood(String neighbor);

    boolean existsByStreetAndNumber(String street, Integer number);
}
