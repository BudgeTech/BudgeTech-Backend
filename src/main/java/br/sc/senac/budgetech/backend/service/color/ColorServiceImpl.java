package br.sc.senac.budgetech.backend.service.color;

import br.sc.senac.budgetech.backend.dto.ColorDTO;
import br.sc.senac.budgetech.backend.mapper.ColorMapper;
import br.sc.senac.budgetech.backend.model.Color;
import br.sc.senac.budgetech.backend.repository.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;

    @Override
    public ColorDTO save(ColorDTO colorDTO) {
        return null;
    }

    @Override
    public void update(ColorDTO colorDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Color findById(Long id) {
        return null;
    }

    @Override
    public Color findByName(String name) {
        return null;
    }

    @Override
    public Color findByBrand(String brand) {
        return null;
    }
}