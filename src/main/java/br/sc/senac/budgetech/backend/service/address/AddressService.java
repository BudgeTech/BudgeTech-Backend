package br.sc.senac.budgetech.backend.service.address;

import br.sc.senac.budgetech.backend.dto.AddressDTO;
import br.sc.senac.budgetech.backend.model.Address;
import br.sc.senac.budgetech.backend.projection.AddressProjection;


public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);

    void update(AddressDTO addressDTO, Long id);

    void delete(Long id);

    AddressProjection findById(Long id);

    AddressProjection findByCity(String city);

    AddressProjection findByNeighbor(String neighbor);
}