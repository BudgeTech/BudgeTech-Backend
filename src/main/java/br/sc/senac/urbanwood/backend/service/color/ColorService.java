package br.sc.senac.urbanwood.backend.service.color;

import br.sc.senac.urbanwood.backend.dto.color.ColorDTO;
import br.sc.senac.urbanwood.backend.projection.color.ColorProjection;

import org.springframework.stereotype.Service;

@Service
public interface ColorService {

    ColorDTO save(ColorDTO colorDTO);

    void update(ColorDTO colorDTO, Long id);

    void delete(Long id);

    ColorProjection findById(Long id);

    ColorProjection findByNameColor(String nameColor);

    ColorProjection findByBrand(String brand);
}