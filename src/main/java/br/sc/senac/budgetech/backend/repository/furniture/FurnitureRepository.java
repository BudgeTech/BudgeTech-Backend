package br.sc.senac.budgetech.backend.repository.furniture;

import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureWithColorProjectionC14andW15andW18;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjectionC15andW17;
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

    List<FurnitureProjection> findFurnitureByNameFurniture(String nameFurniture);

    List<FurnitureProjection> findFurnitureByPriceFurniture(Double priceFurniture);

    List<FurnitureProjection> findFurnitureListByPriceFurniture(Double priceFurniture);

    Optional<FurnitureWithColorProjectionC14andW15andW18> findFurnitureProjectionById(Long id);

    List<FurnitureListProjectionC15andW17> findFurnitureListById(Long id);

    @Query(value = "SELECT furniture_name as nameFurniture, furniture_price as priceFurniture from Furniture", nativeQuery = true)
    Page<FurnitureListProjectionC15andW17> findAllFurnitureBy(Pageable pageable);

    @Query(value = "SELECT f.nameFurniture as nameFurniture, f.image as image, f.priceFurniture as priceFurniture from Furniture f")
    Page<FurnitureListProjectionC15andW17> findAllFurnitureW17By(Pageable pageable);
}
