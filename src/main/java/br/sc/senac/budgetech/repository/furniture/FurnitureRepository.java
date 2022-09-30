package br.sc.senac.budgetech.repository.furniture;

import br.sc.senac.budgetech.model.furniture.Furniture;
import br.sc.senac.budgetech.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.projection.furniture.screen.FurnitureProjectionC14;
import br.sc.senac.budgetech.projection.furniture.screen.FurnitureProjectionC15;
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

    //Screen

    Optional<FurnitureProjectionC14> findFurnitureC14ById(Long id);

    @Query(value = """
            select f.nameFurniture as nameFurniture, f.priceFurniture as priceFurniture, f.image as image
            from Furniture f
            order by f.nameFurniture asc
            """)
    List<FurnitureProjectionC15> findAllOrderByNameFurniture();
}
