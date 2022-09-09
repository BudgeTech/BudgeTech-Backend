package br.sc.senac.budgetech.backend.service.woodwork;

import br.sc.senac.budgetech.backend.dto.WoodworkProfileDTO;
import br.sc.senac.budgetech.backend.dto.WoodworkDTO;
import br.sc.senac.budgetech.backend.projection.WoodworkProfileProjection;
import br.sc.senac.budgetech.backend.projection.WoodworkWithAddressAndContactProjection;
import br.sc.senac.budgetech.backend.projection.WoodworkProjection;
import org.springframework.stereotype.Service;

@Service
public interface WoodworkService {

    WoodworkDTO save(WoodworkDTO woodworkDTO);

    void update(WoodworkDTO woodworkDTO, Long id);

    void delete(Long id);

    WoodworkProjection findById(Long id);

    WoodworkProjection findByCnpj(String cnpj);

    WoodworkProjection findByAddressNeighbor(String neighbor);

    WoodworkProjection findByContactPhoneNumber(String phoneNumber);

    WoodworkProjection findByCompanyName(String companyName);

    WoodworkProjection findByLogin(String login);

    WoodworkWithAddressAndContactProjection findWithAddressAndContactById(Long id);

    WoodworkProfileDTO findProfileById(Long id);

}