package br.sc.senac.budgetech.backend.service.woodwork;

import br.sc.senac.budgetech.backend.dto.WoodworkDTO;
import br.sc.senac.budgetech.backend.mapper.WoodworkMapper;
import br.sc.senac.budgetech.backend.model.Woodwork;
import br.sc.senac.budgetech.backend.projection.WoodworkProjection;
import br.sc.senac.budgetech.backend.repository.AddressRepository;
import br.sc.senac.budgetech.backend.repository.ContactRepository;
import br.sc.senac.budgetech.backend.repository.WoodworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WoodworkServiceImpl implements WoodworkService {

    private final WoodworkRepository woodworkRepository;
    private final WoodworkMapper woodworkMapper;
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;


    @Override
    public WoodworkDTO save(WoodworkDTO woodworkDTO) {
        return null;
    }

    @Override
    public void update(WoodworkDTO woodworkDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Woodwork findById(Long id) {
        return null;
    }

    @Override
    public WoodworkProjection findByCnpj(String cnpj) {
        return null;
    }

    @Override
    public WoodworkProjection findByCompanyName(String companyName) {
        return null;
    }

    @Override
    public Woodwork findByLogin(String login) {
        return null;
    }
}