package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Color;
import br.sc.senac.budgetech.backend.projection.ColorProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<ColorProjection> findColorById(Long id);

    Optional<ColorProjection> findColorByName(String name);

    Optional<ColorProjection> findColorByBrand(String brand);
}
