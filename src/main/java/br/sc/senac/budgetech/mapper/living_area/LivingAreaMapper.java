package br.sc.senac.budgetech.mapper.living_area;


import br.sc.senac.budgetech.dto.living_area.LivingAreaDTO;
import br.sc.senac.budgetech.model.living_area.LivingArea;
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
