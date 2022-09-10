package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.livingArea.LivingAreaDTO;
import br.sc.senac.budgetech.backend.dto.livingArea.LivingAreaTelaDTO;
import br.sc.senac.budgetech.backend.model.LivingArea;
import br.sc.senac.budgetech.backend.projection.livingArea.LivingAreaProjection;
import org.springframework.stereotype.Service;

@Service
public class LivingAreaMapper {

    public LivingAreaDTO toDTO(LivingArea livingArea) {
        return new LivingAreaDTO(livingArea.getId(), livingArea.getNameLivingArea(), livingArea.getImage(), livingArea.getWoodwork().getId());
    }

    public LivingAreaTelaDTO toDTO(LivingAreaProjection livingArea) {
        return new LivingAreaTelaDTO(livingArea.getNameLivingArea(), livingArea.getImage());
    }

    public LivingArea toEntity(LivingAreaDTO dto) {
        return new LivingArea(dto.id(), dto.nameLivingArea(), dto.image());
    }
}
