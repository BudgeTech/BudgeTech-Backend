package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.projection.FurnitureProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

    boolean existsByName(String name);

    Optional<FurnitureProjection> findFurnitureById(Long id);

    Optional<FurnitureProjection> findFurnitureByName(String name);

    Optional<FurnitureProjection> findFurnitureByPrice(double price);
}
