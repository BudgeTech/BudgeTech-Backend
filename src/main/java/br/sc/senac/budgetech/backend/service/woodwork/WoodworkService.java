package br.sc.senac.budgetech.backend.service.woodwork;

import br.sc.senac.budgetech.backend.dto.woodwork.*;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkProjection;
import org.springframework.stereotype.Service;

@Service
public interface WoodworkService {

    WoodworkDTO save(WoodworkDTO woodworkDTO);

    void update(WoodworkDTO woodworkDTO, Long id);

    void delete(Long id);

    WoodworkProjection findById(Long id);

    WoodworkProjection findByCnpj(String cnpj);

    WoodworkProjection findByAddressNeighborhood(String neighborhood);

    WoodworkProjection findByContactPhoneNumber(String phoneNumber);

    WoodworkProjection findByCompanyName(String companyName);

    WoodworkSearchDTO findSearchById(Long id);

    WoodworkProfileDTO findProfileById(Long id);

    WoodworkProfileEditDTO findProfileEditById(Long id);

    WoodworkProfileFullEditDTO findProfileFullEditById(Long id);

}