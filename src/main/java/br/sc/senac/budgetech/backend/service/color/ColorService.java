package br.sc.senac.budgetech.backend.service.color;

import br.sc.senac.budgetech.backend.dto.color.ColorDTO;
import br.sc.senac.budgetech.backend.projection.color.ColorProjection;
import org.springframework.stereotype.Service;

@Service
public interface ColorService {

    ColorDTO save(ColorDTO colorDTO);

    void update(ColorDTO colorDTO, Long id);

    void delete(Long id);

    ColorProjection findById(Long id);

    ColorProjection findByName(String name);

    ColorProjection findByBrand(String brand);
}