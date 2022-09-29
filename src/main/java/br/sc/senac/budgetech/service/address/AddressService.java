package br.sc.senac.budgetech.service.address;

import br.sc.senac.budgetech.dto.address.AddressDTO;
import br.sc.senac.budgetech.projection.address.AddressProjection;

import java.util.List;

public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);

    void update(AddressDTO addressDTO, Long id);

    void delete(Long id);

    AddressProjection findById(Long id);

    List<AddressProjection> findByNeighborhood(String neighborhood);
}