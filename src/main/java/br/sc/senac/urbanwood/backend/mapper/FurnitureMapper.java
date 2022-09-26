package br.sc.senac.urbanwood.backend.mapper;

import br.sc.senac.urbanwood.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.urbanwood.backend.dto.furniture.FurnitureListDTO;
import br.sc.senac.urbanwood.backend.dto.furniture.FurnitureTelaDTO;
import br.sc.senac.urbanwood.backend.model.Furniture;
import br.sc.senac.urbanwood.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.urbanwood.backend.projection.furniture.FurnitureProjection;

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
}
