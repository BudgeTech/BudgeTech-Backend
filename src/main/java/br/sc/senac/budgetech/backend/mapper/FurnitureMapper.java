package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureListDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureTelaDTO;
import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureMapper {

    public FurnitureDTO toDTO(Furniture furniture) {
        return new FurnitureDTO(furniture.getId(), furniture.getNameFurniture(), furniture.getDescription(), furniture.getFurnitureSize(), furniture.getPriceFurniture(), furniture.getLivingArea().getId());
    }

    public Furniture toEntity(FurnitureDTO dto) {
        return new Furniture(dto.id(), dto.nameFurniture(), dto.description(), dto.furnitureSize(), dto.priceFurniture());
    }

    public FurnitureTelaDTO toDTO(FurnitureProjection furniture) {
        return new FurnitureTelaDTO(furniture.getNameFurniture(), furniture.getImage(), furniture.getPriceFurniture());
    }

    public FurnitureListDTO toDTO(List<FurnitureListProjection> furniture) {
        return new FurnitureListDTO(furniture);
    }

    public FurnitureListDTO toDTO(Page<FurnitureListProjection> furniture) {
        return new FurnitureListDTO(furniture.toList());
    }
}
