package br.sc.senac.budgetech.mapper.furniture;

import br.sc.senac.budgetech.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.model.furniture.Furniture;
import org.springframework.stereotype.Service;

@Service
public class FurnitureMapper {

    public FurnitureDTO toDTO(Furniture furniture) {
        return new FurnitureDTO(furniture.getId(), furniture.getNameFurniture(), furniture.getDescription(), furniture.getFurnitureSize(), furniture.getPriceFurniture(), furniture.getImage(),furniture.getLivingArea().getId());
    }

    public Furniture toEntity(FurnitureDTO dto) {
        return new Furniture(dto.id(), dto.nameFurniture(), dto.description(), dto.furnitureSize(), dto.priceFurniture());
    }
}
