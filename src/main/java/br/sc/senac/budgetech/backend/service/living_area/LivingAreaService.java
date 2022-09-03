package br.sc.senac.budgetech.backend.service.living_area;

import br.sc.senac.budgetech.backend.dto.LivingAreaDTO;
import br.sc.senac.budgetech.backend.model.LivingArea;
import br.sc.senac.budgetech.backend.projection.LivingAreaProjection;
import org.springframework.stereotype.Service;

@Service
public interface LivingAreaService {

    LivingAreaDTO save(LivingAreaDTO livingAreaDTO);

    void update(LivingAreaDTO livingAreaDTO, Long id);

    void delete(Long id);

    LivingAreaProjection findById(Long id);

    LivingAreaProjection findByName(String name);
}