package br.sc.senac.urbanwood.service.living_area;

import br.sc.senac.urbanwood.dto.living_area.LivingAreaDTO;
import br.sc.senac.urbanwood.exception.living_area.LivingAreaNotFoundException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.mapper.living_area.LivingAreaMapper;
import br.sc.senac.urbanwood.model.living_area.LivingArea;
import br.sc.senac.urbanwood.model.woodwork.Woodwork;
import br.sc.senac.urbanwood.projection.living_area.LivingAreaProjection;
import br.sc.senac.urbanwood.projection.living_area.screen.LivingAreaProjectionC16;
import br.sc.senac.urbanwood.repository.living_area.LivingAreaRepository;
import br.sc.senac.urbanwood.repository.woodwork.WoodworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivingAreaServiceImpl implements LivingAreaService {

    private final LivingAreaRepository livingAreaRepository;
    private final LivingAreaMapper livingAreaMapper;
    private final WoodworkRepository woodworkRepository;

    public LivingAreaServiceImpl(LivingAreaRepository livingAreaRepository, LivingAreaMapper livingAreaMapper, WoodworkRepository woodworkRepository) {
        this.livingAreaRepository = livingAreaRepository;
        this.livingAreaMapper = livingAreaMapper;
        this.woodworkRepository = woodworkRepository;
    }

    public LivingAreaDTO save(LivingAreaDTO livingAreaDTO) {

        Woodwork woodwork = woodworkRepository.findById(livingAreaDTO.idWoodwork())
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + livingAreaDTO.idWoodwork() + " was not found"));

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

    public List<LivingAreaProjection> findByNameLivingArea(String nameLivingArea) {
        List<LivingAreaProjection> livingArea = livingAreaRepository.findLivingAreaByNameLivingArea(nameLivingArea);

        if(livingArea.isEmpty())
            throw new LivingAreaNotFoundException("Living Area " + nameLivingArea + " was not found");
        return livingArea;
    }

    //Screen

    public List<LivingAreaProjectionC16> findC16OrderByName() {
        List<LivingAreaProjectionC16> livingArea = livingAreaRepository.findAllOrderByName();

        if(livingArea.isEmpty())
            throw new LivingAreaNotFoundException("Was not found");
        return livingArea;
    }
}