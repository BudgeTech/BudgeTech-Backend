package br.sc.senac.budgetech.backend.service.woodwork;

import br.sc.senac.budgetech.backend.dto.woodwork.*;
import br.sc.senac.budgetech.backend.projection.woodwork.*;
import org.springframework.stereotype.Service;

import java.util.List;

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

    List<WoodworkSearchProjection> findSearchById(Long id);

    WoodworkProfileProjection findProfileById(Long id);

    WoodworkProfileEditProjection findProfileEditById(Long id);

    WoodworkProfileFullEditProjection findProfileFullEditById(Long id);

}