package br.sc.senac.budgetech.backend.service.address;


import br.sc.senac.budgetech.backend.dto.AddressDTO;
import br.sc.senac.budgetech.backend.mapper.AddressMapper;
import br.sc.senac.budgetech.backend.model.Address;
import br.sc.senac.budgetech.backend.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public void update(AddressDTO addressDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Address findById(Long id) {
        return null;
    }
}