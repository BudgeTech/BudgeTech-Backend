package br.sc.senac.budgetech.backend.service.living_area;

import br.sc.senac.budgetech.backend.dto.LivingAreaDTO;
import br.sc.senac.budgetech.backend.model.LivingArea;
import br.sc.senac.budgetech.backend.projection.LivingAreaProjection;
import org.springframework.stereotype.Service;

@Service
public interface LivingAreaService {

    LivingAreaDTO save(LivingAreaDTO furnitureDTO);

    void update(LivingAreaDTO furnitureDTO, Long id);

    void delete(Long id);

    LivingArea findById(Long id);

    LivingAreaProjection findByName(String name);
}