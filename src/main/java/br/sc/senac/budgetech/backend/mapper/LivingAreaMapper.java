package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.LivingAreaDTO;
import br.sc.senac.budgetech.backend.model.LivingArea;
import org.springframework.stereotype.Service;

@Service
public class LivingAreaMapper {

    public LivingAreaDTO toDTO(LivingArea livingArea) {
        return new LivingAreaDTO(livingArea.getId(), livingArea.getName(), livingArea.getWoodwork().getId());
    }

    public LivingArea toEntity(LivingAreaDTO dto) {
        return new LivingArea(dto.id(), dto.name());
    }
}
