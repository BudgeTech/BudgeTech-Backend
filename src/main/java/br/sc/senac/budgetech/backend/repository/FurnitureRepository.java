package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.projection.FurnitureBasicProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

    boolean existsByName(String name);

    Optional<Furniture> findFurnitureById(Long id);

    Optional<FurnitureBasicProjection> findFurnitureByName(String name);

    Optional<FurnitureBasicProjection> findFurnitureByPrice(double price);
}
