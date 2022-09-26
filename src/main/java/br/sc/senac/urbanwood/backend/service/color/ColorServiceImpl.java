package br.sc.senac.urbanwood.backend.service.color;

import br.sc.senac.urbanwood.backend.dto.color.ColorDTO;
import br.sc.senac.urbanwood.backend.exception.color.ColorNotFoundException;
import br.sc.senac.urbanwood.backend.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.urbanwood.backend.mapper.ColorMapper;
import br.sc.senac.urbanwood.backend.model.Color;
import br.sc.senac.urbanwood.backend.model.Furniture;
import br.sc.senac.urbanwood.backend.projection.color.ColorProjection;
import br.sc.senac.urbanwood.backend.repository.ColorRepository;
import br.sc.senac.urbanwood.backend.repository.FurnitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;
    private final FurnitureRepository furnitureRepository;

    public ColorDTO save(ColorDTO colorDTO) {

        Furniture furniture = furnitureRepository.findById(colorDTO.idFurniture())
                .orElseThrow(() -> new FurnitureNotFoundException("Furniture " + colorDTO.idFurniture() + " was not found"));

        Color color = colorMapper.toEntity(colorDTO);
        color.setFurniture(furniture);
        Color colorSaved = colorRepository.save(color);
        return colorMapper.toDTO(colorSaved);
    }

    public void update(ColorDTO colorDTO, Long id) {

        Color color = colorRepository.findById(id)
                .orElseThrow(() -> new ColorNotFoundException("Color " + id + " was not found"));

        color.setNameColor((colorDTO.nameColor() != null && !colorDTO.nameColor().isBlank()) ? colorDTO.nameColor() : color.getNameColor());
        color.setBrand((colorDTO.brand() != null && !colorDTO.brand().isBlank()) ? colorDTO.brand() : color.getBrand());
        colorRepository.save(color);
    }

    public void delete(Long id) {
        if (!colorRepository.existsById(id))
            throw new ColorNotFoundException("Color " + id + " was not found");
        colorRepository.deleteById(id);
    }

    public ColorProjection findById(Long id) {
        return colorRepository.findColorById(id)
                .orElseThrow(() -> new ColorNotFoundException("Color " + id + " was not found"));
    }

    public ColorProjection findByNameColor(String nameColor) {
        return colorRepository.findColorByNameColor(nameColor)
                .orElseThrow(() -> new ColorNotFoundException("Name " + nameColor + " was not found"));
    }

    public ColorProjection findByBrand(String brand) {
        return colorRepository.findColorByBrand(brand)
                .orElseThrow(() -> new ColorNotFoundException("Brand " + brand + " was not found"));
    }
}