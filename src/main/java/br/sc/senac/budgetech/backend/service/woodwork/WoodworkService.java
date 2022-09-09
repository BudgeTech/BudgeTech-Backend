package br.sc.senac.budgetech.backend.service.woodwork;

import br.sc.senac.budgetech.backend.dto.woodwork.WoodworkDTO;
import br.sc.senac.budgetech.backend.dto.woodwork.WoodworkProfileDTO;
import br.sc.senac.budgetech.backend.dto.woodwork.WoodworkProfileEditDTO;
import br.sc.senac.budgetech.backend.dto.woodwork.WoodworkProfileFullEditDTO;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkProfileFullEditProjection;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkProjection;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkWithAddressAndContactProjection;
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

    WoodworkProfileEditDTO findProfileEditById(Long id);

    WoodworkProfileFullEditDTO findProfileFullEditById(Long id);

}