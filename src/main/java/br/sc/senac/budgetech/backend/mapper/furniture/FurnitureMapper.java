package br.sc.senac.budgetech.backend.mapper.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureMapper {

    public FurnitureDTO toDTO(Furniture furniture) {
        return new FurnitureDTO(furniture.getId(), furniture.getNameFurniture(), furniture.getDescription(), furniture.getFurnitureSize(), furniture.getPriceFurniture(), furniture.getImage(),furniture.getLivingArea().getId());
    }

    public Furniture toEntity(FurnitureDTO dto) {
        return new Furniture(dto.id(), dto.nameFurniture(), dto.description(), dto.furnitureSize(), dto.priceFurniture());
    }
}
