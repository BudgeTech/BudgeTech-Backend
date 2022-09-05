package br.sc.senac.budgetech.backend.service.color;

import br.sc.senac.budgetech.backend.dto.ColorDTO;
import br.sc.senac.budgetech.backend.exception.color.ColorNotFoundException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.budgetech.backend.mapper.ColorMapper;
import br.sc.senac.budgetech.backend.model.Color;
import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.projection.ColorProjection;
import br.sc.senac.budgetech.backend.repository.ColorRepository;
import br.sc.senac.budgetech.backend.repository.FurnitureRepository;
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

        color.setName((colorDTO.name() != null && !colorDTO.name().isBlank()) ? colorDTO.name() : color.getName());
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

    public ColorProjection findByName(String name) {
        return colorRepository.findColorByName(name)
                .orElseThrow(() -> new ColorNotFoundException("Name " + name + " was not found"));
    }

    public ColorProjection findByBrand(String brand) {
        return colorRepository.findColorByBrand(brand)
                .orElseThrow(() -> new ColorNotFoundException("Brand " + brand + " was not found"));
    }
}