package br.sc.senac.budgetech.backend.mapper.livingArea;

import br.sc.senac.budgetech.backend.dto.livingArea.LivingAreaDTO;
import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import org.springframework.stereotype.Service;

@Service
public class LivingAreaMapper {

    public LivingAreaDTO toDTO(LivingArea livingArea) {
        return new LivingAreaDTO(livingArea.getId(), livingArea.getNameLivingArea(), livingArea.getImage(), livingArea.getWoodwork().getId());
    }

    public LivingArea toEntity(LivingAreaDTO dto) {
        return new LivingArea(dto.id(), dto.nameLivingArea(), dto.image());
    }
}
