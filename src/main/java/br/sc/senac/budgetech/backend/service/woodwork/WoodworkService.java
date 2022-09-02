package br.sc.senac.budgetech.backend.service.woodwork;

import br.sc.senac.budgetech.backend.dto.WoodworkDTO;
import br.sc.senac.budgetech.backend.model.Woodwork;
import br.sc.senac.budgetech.backend.projection.WoodworkProjection;
import org.springframework.stereotype.Service;

@Service
public interface WoodworkService {

    WoodworkDTO save(WoodworkDTO woodworkDTO);

    void update(WoodworkDTO woodworkDTO, Long id);

    void delete(Long id);

    Woodwork findById(Long id);

    WoodworkProjection findByCnpj(String cnpj);

    WoodworkProjection findByCompanyName(String companyName);

    Woodwork findByLogin(String login);
}