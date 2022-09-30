package br.sc.senac.urbanwood.service.furniture;

import br.sc.senac.urbanwood.dto.furniture.FurnitureDTO;
import br.sc.senac.urbanwood.projection.furniture.FurnitureProjection;
import br.sc.senac.urbanwood.projection.furniture.screen.FurnitureProjectionC14;
import br.sc.senac.urbanwood.projection.furniture.screen.FurnitureProjectionC15;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FurnitureService {

    FurnitureDTO save(FurnitureDTO furnitureDTO);

    void update(FurnitureDTO furnitureDTO, Long id);

    void delete(Long id);

    FurnitureProjection findById(Long id);

    List<FurnitureProjection> findByNameFurniture(String nameFurniture);

    List<FurnitureProjection> findByPriceFurniture(Double priceFurniture);

    //Screen

    FurnitureProjectionC14 findC14ById(Long id);

    List<FurnitureProjectionC15> findC15OrderByNameFurniture();
}