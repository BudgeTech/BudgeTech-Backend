package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureListDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureScreenDTO;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface FurnitureService {

    FurnitureDTO save(FurnitureDTO furnitureDTO);

    void update(FurnitureDTO furnitureDTO, Long id);

    void delete(Long id);

    FurnitureProjection findById(Long id);

    FurnitureProjection findByNameFurniture(String nameFurniture);

    FurnitureProjection findByPriceFurniture(Double priceFurniture);

    Page<FurnitureListProjection> findFurnitureOrderByAscName(Integer page);

    FurnitureListDTO findFurnitureDTOOrderByAscName(Integer page);

    FurnitureScreenDTO findByIdDTO(Long id);

    FurnitureListDTO findFurnitureListById(Long id);
}