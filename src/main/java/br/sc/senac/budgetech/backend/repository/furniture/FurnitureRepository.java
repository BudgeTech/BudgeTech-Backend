package br.sc.senac.budgetech.backend.repository.furniture;

import br.sc.senac.budgetech.backend.model.furniture.Furniture;
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

    //DTOS  ||
    //      ||
    //      vv

    List<FurnitureListProjection> findFurnitureListById(Long id);


    ///

    List<FurnitureListProjection> findAllProjectedFurnitureBy();

    @Query(value = "SELECT furniture_name as nameFurniture, furniture_price as priceFurniture, furniture_image as image from Furniture", nativeQuery = true)
    Page<FurnitureListProjection> findAllFurnitureBy(Pageable pageable);

//    @Query(value = "SELECT furniture_name as nameFurniture, furniture_price as priceFurniture, furniture_image as image from Furniture", nativeQuery = true)
//    Page<FurnitureListDTO> findAllFurnitureDTO(Pageable pageable);
}
