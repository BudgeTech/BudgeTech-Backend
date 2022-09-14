package br.sc.senac.budgetech.backend.repository.furniture;

import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

    boolean existsByNameFurniture(String nameFurniture);

    Optional<FurnitureProjection> findFurnitureById(Long id);

    Optional<FurnitureProjection> findFurnitureByNameFurniture(String nameFurniture);

    Optional<FurnitureProjection> findFurnitureByPriceFurniture(Double priceFurniture);

    //DTOS  ||
    //      ||
    //      vv

    List<FurnitureListProjection> findFurnitureListById(Long id);

    List<FurnitureListProjection> findAllProjectedFurnitureBy();

    List<Furniture> findAll();
}
