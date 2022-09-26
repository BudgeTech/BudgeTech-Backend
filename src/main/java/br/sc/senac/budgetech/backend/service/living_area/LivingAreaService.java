package br.sc.senac.budgetech.backend.service.living_area;

import br.sc.senac.budgetech.backend.dto.livingArea.LivingAreaDTO;
import br.sc.senac.budgetech.backend.projection.livingArea.LivingAreaProjectionC16andW16;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LivingAreaService {

    LivingAreaDTO save(LivingAreaDTO livingAreaDTO);

    void update(LivingAreaDTO livingAreaDTO, Long id);

    void delete(Long id);

    LivingAreaProjectionC16andW16 findById(Long id);

    List<LivingAreaProjectionC16andW16> findByNameLivingArea(String nameLivingArea);
}