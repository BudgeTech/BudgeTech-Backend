package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureWithColorProjectionC14andW15andW18;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjectionC15andW17;
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

    FurnitureWithColorProjectionC14andW15andW18 findFurnitureById(Long id);

    List<FurnitureProjection> findListByPriceFurniture(Double priceFurniture);

    List<FurnitureListProjectionC15andW17> findListById(Long id);

    Page<FurnitureListProjectionC15andW17> findWithPaginationAndSorting(int offset, int pageSize, String field);

    Page<FurnitureListProjectionC15andW17> findWithPaginationAndSortingByPriceFurniture(Pageable pageable, Integer page);

    Page<FurnitureListProjectionC15andW17> findWithPaginationAndSortingByNameFurniture(Pageable pageable, Integer page);

    Page<FurnitureListProjectionC15andW17> findWithPaginationAndSortingByNameFurnitureW17(Pageable pageable, Integer page);
}