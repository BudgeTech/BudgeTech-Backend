package br.sc.senac.urbanwood.service.address;

import br.sc.senac.urbanwood.dto.address.AddressDTO;
import br.sc.senac.urbanwood.projection.address.AddressProjection;

import java.util.List;

public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);

    void update(AddressDTO addressDTO, Long id);

    void delete(Long id);

    AddressProjection findById(Long id);

    List<AddressProjection> findByNeighborhood(String neighborhood);
}