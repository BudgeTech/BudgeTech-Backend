package br.sc.senac.urbanwood.backend.repository;

import br.sc.senac.urbanwood.backend.model.Color;
import br.sc.senac.urbanwood.backend.projection.color.ColorProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<ColorProjection> findColorById(Long id);

    Optional<ColorProjection> findColorByNameColor(String nameColor);

    Optional<ColorProjection> findColorByBrand(String brand);
}
