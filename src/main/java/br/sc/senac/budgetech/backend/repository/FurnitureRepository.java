package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Furniture;
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

    //É tanto usado pela consulta quanto o DTO
    Optional<FurnitureProjection> findFurnitureById(Long id);

    Optional<FurnitureProjection> findFurnitureByNameFurniture(String nameFurniture);

    Optional<FurnitureProjection> findFurnitureByPriceFurniture(double priceFurniture);

    //DTOS  ||
    //      ||
    //      vv

    List<FurnitureListProjection> findFurnitureListById(Long id);

//    @Query(value = "SELECT f.furniture_name AS NameFurniture, f.furniture_price AS PriceFurniture FROM Furniture f")
//    Page<FurnitureListProjection> findTestFurniture(Pageable pageable);
}
