package br.sc.senac.budgetech.backend.service.address;

import br.sc.senac.budgetech.backend.dto.address.AddressDTO;
import br.sc.senac.budgetech.backend.projection.address.AddressProjection;


public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);

    void update(AddressDTO addressDTO, Long id);

    void delete(Long id);

    AddressProjection findById(Long id);

    AddressProjection findByCity(String city);

    AddressProjection findByNeighbor(String neighbor);
}