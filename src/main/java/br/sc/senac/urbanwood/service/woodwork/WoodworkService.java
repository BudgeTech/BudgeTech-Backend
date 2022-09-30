package br.sc.senac.urbanwood.service.woodwork;

import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC8;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC9;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW6;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW7;
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

    WoodworkProjectionW6 findW6ById(Long id);

    WoodworkProjectionW7 findW7ById(Long id);
}