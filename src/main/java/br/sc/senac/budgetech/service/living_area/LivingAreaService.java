package br.sc.senac.budgetech.service.living_area;

import br.sc.senac.budgetech.dto.living_area.LivingAreaDTO;
import br.sc.senac.budgetech.projection.living_area.LivingAreaProjection;
import br.sc.senac.budgetech.projection.living_area.screen.LivingAreaProjectionC16;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LivingAreaService {

    LivingAreaDTO save(LivingAreaDTO livingAreaDTO);

    void update(LivingAreaDTO livingAreaDTO, Long id);

    void delete(Long id);

    LivingAreaProjection findById(Long id);

    List<LivingAreaProjection> findByNameLivingArea(String nameLivingArea);

    //Screen

    List<LivingAreaProjectionC16> findC16OrderByName();
}