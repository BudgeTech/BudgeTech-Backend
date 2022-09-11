package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureListDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureTelaDTO;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface FurnitureService {

    FurnitureDTO save(FurnitureDTO furnitureDTO);

    void update(FurnitureDTO furnitureDTO, Long id);

    void delete(Long id);

    FurnitureProjection findById(Long id);

    FurnitureProjection findByNameFurniture(String nameFurniture);

    FurnitureProjection findByPriceFurniture(double priceFurniture);

    FurnitureTelaDTO findByIdDTO(Long id);

    FurnitureListDTO findFurnitureListById(Long id);

//    FurnitureListDTO findAll(Pageable pageable);
}