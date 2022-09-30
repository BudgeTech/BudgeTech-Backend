package br.sc.senac.urbanwood.mapper.color;

import br.sc.senac.urbanwood.dto.color.ColorDTO;
import br.sc.senac.urbanwood.model.color.Color;
import org.springframework.stereotype.Service;

@Service
public class ColorMapper {

    public ColorDTO toDTO(Color color) {
        return new ColorDTO(color.getId(), color.getNameColor(), color.getBrand(), color.getFurniture().getId());
    }

    public Color toEntity(ColorDTO dto) {
        return new Color(dto.id(), dto.nameColor(), dto.brand());
    }
}
