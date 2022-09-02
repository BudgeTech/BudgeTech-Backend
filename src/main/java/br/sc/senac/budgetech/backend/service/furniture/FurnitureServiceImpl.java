package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.FurnitureDTO;
import br.sc.senac.budgetech.backend.mapper.FurnitureMapper;
import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.projection.FurnitureBasicProjection;
import br.sc.senac.budgetech.backend.repository.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.ItemRepository;
import br.sc.senac.budgetech.backend.repository.LivingAreaRepository;
import br.sc.senac.budgetech.backend.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;
    private final LivingAreaRepository livingAreaRepository;
    private final RequestRepository requestRepository;
    private final ItemRepository itemRepository;


    @Override
    public FurnitureDTO save(FurnitureDTO furnitureDTO) {
        return null;
    }

    @Override
    public void update(FurnitureDTO furnitureDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Furniture findById(Long id) {
        return null;
    }

    @Override
    public FurnitureBasicProjection findByName(String name) {
        return null;
    }

    @Override
    public Furniture findByFootage(double footage) {
        return null;
    }

    @Override
    public FurnitureBasicProjection findByPrice(double price) {
        return null;
    }
}