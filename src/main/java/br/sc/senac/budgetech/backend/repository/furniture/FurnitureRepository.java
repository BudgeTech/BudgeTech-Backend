package br.sc.senac.budgetech.backend.repository.furniture;

import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureFullProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

    boolean existsByNameFurniture(String nameFurniture);

    Optional<FurnitureProjection> findFurnitureById(Long id);

    Optional<FurnitureProjection> findFurnitureByNameFurniture(String nameFurniture);

    Optional<FurnitureProjection> findFurnitureByPriceFurniture(Double priceFurniture);

    List<FurnitureProjection> findFurnitureListByPriceFurniture(Double priceFurniture);

    Optional<FurnitureFullProjection> findFurnitureProjectionById(Long id);

    List<FurnitureListProjection> findFurnitureListById(Long id);

    @Query(value = "SELECT furniture_name as nameFurniture, furniture_price as priceFurniture from Furniture", nativeQuery = true)
    Page<FurnitureListProjection> findAllFurnitureBy(Pageable pageable);
}
