package br.sc.senac.budgetech.backend.service.living_area;

import br.sc.senac.budgetech.backend.dto.LivingAreaDTO;
import br.sc.senac.budgetech.backend.mapper.LivingAreaMapper;
import br.sc.senac.budgetech.backend.model.LivingArea;
import br.sc.senac.budgetech.backend.projection.LivingAreaProjection;
import br.sc.senac.budgetech.backend.repository.LivingAreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LivingAreaServiceImpl implements LivingAreaService {

    private LivingAreaRepository livingAreaRepository;
    private LivingAreaMapper livingAreaMapper;

    @Override
    public LivingAreaDTO save(LivingAreaDTO furnitureDTO) {
        return null;
    }

    @Override
    public void update(LivingAreaDTO furnitureDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public LivingArea findById(Long id) {
        return null;
    }

    @Override
    public LivingAreaProjection findByName(String name) {
        return null;
    }
}