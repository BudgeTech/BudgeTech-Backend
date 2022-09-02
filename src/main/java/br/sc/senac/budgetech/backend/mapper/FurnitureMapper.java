package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.FurnitureDTO;
import br.sc.senac.budgetech.backend.model.Furniture;
import org.springframework.stereotype.Service;

@Service
public class FurnitureMapper {

    public FurnitureDTO toDTO(Furniture furniture) {
        return new FurnitureDTO(furniture.getId(), furniture.getName(), furniture.getDescription(), furniture.getFurnitureSize(), furniture.getPrice(), furniture.getWoodwork().getId(), furniture.getLivingArea().getId(), furniture.getRequest().getId(), furniture.getItem().getId());
    }

    public Furniture toEntity(FurnitureDTO dto) {
        return new Furniture(dto.id(), dto.name(), dto.description(), dto.furnitureSize(), dto.price());
    }
}
