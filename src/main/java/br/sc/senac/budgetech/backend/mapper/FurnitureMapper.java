package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureTelaDTO;
import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import org.springframework.stereotype.Service;

@Service
public class FurnitureMapper {

    public FurnitureDTO toDTO(Furniture furniture) {
        return new FurnitureDTO(furniture.getId(), furniture.getName(), furniture.getDescription(), furniture.getFurnitureSize(), furniture.getPrice(), furniture.getLivingArea().getId());
    }

    public Furniture toEntity(FurnitureDTO dto) {
        return new Furniture(dto.id(), dto.name(), dto.description(), dto.furnitureSize(), dto.price());
    }

    public FurnitureTelaDTO toDTO(FurnitureProjection furniture) {
        return new FurnitureTelaDTO(furniture.getName(), furniture.getImage(), furniture.getPrice());
    }
}
