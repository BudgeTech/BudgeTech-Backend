package br.sc.senac.budgetech.backend.service.living_area;

import br.sc.senac.budgetech.backend.dto.livingArea.LivingAreaDTO;
import br.sc.senac.budgetech.backend.exception.livingarea.LivingAreaNotFoundException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.budgetech.backend.mapper.livingArea.LivingAreaMapper;
import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import br.sc.senac.budgetech.backend.model.user.User;
import br.sc.senac.budgetech.backend.model.woodwork.Woodwork;
import br.sc.senac.budgetech.backend.projection.livingArea.LivingAreaProjection;
import br.sc.senac.budgetech.backend.repository.livingArea.LivingAreaRepository;
import br.sc.senac.budgetech.backend.repository.woodwork.WoodworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LivingAreaServiceImpl implements LivingAreaService {

    private LivingAreaRepository livingAreaRepository;
    private LivingAreaMapper livingAreaMapper;
    private WoodworkRepository woodworkRepository;

    public LivingAreaDTO save(LivingAreaDTO livingAreaDTO) {

        Woodwork woodwork = woodworkRepository.findById(livingAreaDTO.idWoodwork())
                .orElseThrow(() -> new WoodworkNotFoundException("User " + livingAreaDTO.idWoodwork() + " was not found"));

        LivingArea livingArea = livingAreaMapper.toEntity(livingAreaDTO);
        livingArea.setWoodwork(woodwork);
        LivingArea livingSaved = livingAreaRepository.save(livingArea);
        return livingAreaMapper.toDTO(livingSaved);
    }

    public void update(LivingAreaDTO livingAreaDTO, Long id) {

        LivingArea livingArea = livingAreaRepository.findById(id)
                .orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + id + " was not found"));

        livingArea.setNameLivingArea(livingAreaDTO.nameLivingArea());
        livingAreaRepository.save(livingArea);
    }

    public void delete(Long id) {
        if (!livingAreaRepository.existsById(id))
            throw new LivingAreaNotFoundException("Living Area " + id + " was not found");
        livingAreaRepository.deleteById(id);
    }

    public LivingAreaProjection findById(Long id) {
        return livingAreaRepository.findLivingAreaById(id)
                .orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + id + " was not found"));

    }

    public LivingAreaProjection findByNameLivingArea(String nameLivingArea) {
        return livingAreaRepository.findLivingAreaByNameLivingArea(nameLivingArea)
                .orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + nameLivingArea + " was not found"));
    }
}