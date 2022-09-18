package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FurnitureService {

    FurnitureDTO save(FurnitureDTO furnitureDTO);

    void update(FurnitureDTO furnitureDTO, Long id);

    void delete(Long id);

    FurnitureProjection findById(Long id);

    FurnitureProjection findByNameFurniture(String nameFurniture);

    FurnitureProjection findByPriceFurniture(Double priceFurniture);

    List<FurnitureProjection> findListByPriceFurniture(Double priceFurniture);

    List<FurnitureListProjection> findListById(Long id);

    Page<FurnitureListProjection> findWithPaginationAndSorting(int offset, int pageSize, String field);

    Page<FurnitureListProjection> findWithPaginationAndSortingByPriceFurniture(Pageable pageable, Integer page);

    Page<FurnitureListProjection> findWithPaginationAndSortingByNameFurniture(Pageable pageable, Integer page);
}