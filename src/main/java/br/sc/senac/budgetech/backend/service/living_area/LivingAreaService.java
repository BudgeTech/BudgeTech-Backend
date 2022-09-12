package br.sc.senac.budgetech.backend.service.living_area;

import br.sc.senac.budgetech.backend.dto.livingArea.LivingAreaDTO;
import br.sc.senac.budgetech.backend.dto.livingArea.LivingAreaTelaDTO;
import br.sc.senac.budgetech.backend.projection.livingArea.LivingAreaProjection;
import org.springframework.stereotype.Service;

@Service
public interface LivingAreaService {

    LivingAreaDTO save(LivingAreaDTO livingAreaDTO);

    void update(LivingAreaDTO livingAreaDTO, Long id);

    void delete(Long id);

    LivingAreaProjection findById(Long id);

    LivingAreaProjection findByNameLivingArea(String nameLivingArea);

    LivingAreaTelaDTO findByIdDTO(Long id);
}