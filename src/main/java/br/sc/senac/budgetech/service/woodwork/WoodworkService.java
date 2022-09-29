package br.sc.senac.budgetech.service.woodwork;

import br.sc.senac.budgetech.dto.woodwork.WoodworkDTO;
import br.sc.senac.budgetech.projection.woodwork.WoodworkProjection;
import br.sc.senac.budgetech.projection.woodwork.screen.WoodworkProjectionC8;
import br.sc.senac.budgetech.projection.woodwork.screen.WoodworkProjectionC9;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WoodworkService {

    WoodworkDTO save(WoodworkDTO woodworkDTO);

    void update(WoodworkDTO woodworkDTO, Long id);

    void delete(Long id);

    WoodworkProjection findById(Long id);

    List<WoodworkProjection> findByCompanyName(String companyName);

    WoodworkProjection findByCnpj(String cnpj);

    //Screen

    WoodworkProjectionC8 findC8ById(Long id);

    List<WoodworkProjectionC9> findC9ByName(String companyName);
}