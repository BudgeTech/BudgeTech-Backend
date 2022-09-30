package br.sc.senac.urbanwood.service.color;

import br.sc.senac.urbanwood.dto.color.ColorDTO;
import br.sc.senac.urbanwood.projection.color.ColorProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColorService {

    ColorDTO save(ColorDTO colorDTO);

    void update(ColorDTO colorDTO, Long id);

    void delete(Long id);

    ColorProjection findById(Long id);

    List<ColorProjection> findByNameColor(String nameColor);

    List<ColorProjection> findByBrand(String brand);
}