package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.FurnitureDTO;
import br.sc.senac.budgetech.backend.projection.FurnitureProjection;
import org.springframework.stereotype.Service;

@Service
public interface FurnitureService {

    FurnitureDTO save(FurnitureDTO furnitureDTO);

    void update(FurnitureDTO furnitureDTO, Long id);

    void delete(Long id);

    FurnitureProjection findById(Long id);

    FurnitureProjection findByName(String name);

    FurnitureProjection findByPrice(double price);
}