package br.sc.senac.budgetech.backend.service.color;

import br.sc.senac.budgetech.backend.dto.ColorDTO;
import br.sc.senac.budgetech.backend.model.Color;
import org.springframework.stereotype.Service;

@Service
public interface ColorService {

    ColorDTO save(ColorDTO colorDTO);

    void update(ColorDTO colorDTO, Long id);

    void delete(Long id);

    Color findById(Long id);

    Color findByName(String name);

    Color findByBrand(String brand);
}