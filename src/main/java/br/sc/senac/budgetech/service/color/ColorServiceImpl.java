package br.sc.senac.budgetech.service.color;

import br.sc.senac.budgetech.dto.color.ColorDTO;
import br.sc.senac.budgetech.exception.color.ColorNotFoundException;
import br.sc.senac.budgetech.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.budgetech.mapper.color.ColorMapper;
import br.sc.senac.budgetech.model.color.Color;
import br.sc.senac.budgetech.model.furniture.Furniture;
import br.sc.senac.budgetech.projection.color.ColorProjection;
import br.sc.senac.budgetech.repository.color.ColorRepository;
import br.sc.senac.budgetech.repository.furniture.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;
    private final FurnitureRepository furnitureRepository;

    public ColorServiceImpl(ColorRepository colorRepository, ColorMapper colorMapper, FurnitureRepository furnitureRepository) {
        this.colorRepository = colorRepository;
        this.colorMapper = colorMapper;
        this.furnitureRepository = furnitureRepository;
    }

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

        color.setBrand(colorDTO.brand());
        color.setNameColor(colorDTO.nameColor());
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

    public List<ColorProjection> findByNameColor(String nameColor) {
        List<ColorProjection> color = colorRepository.findColorByNameColor(nameColor);

        if(color.isEmpty())
            throw new ColorNotFoundException("Name " + nameColor + " was not found");
        return color;
    }

    public List<ColorProjection>  findByBrand(String brand) {
        List<ColorProjection> color = colorRepository.findColorByBrand(brand);

        if(color.isEmpty())
            throw new ColorNotFoundException("Brand " + brand + " was not found");
        return color;
    }
}