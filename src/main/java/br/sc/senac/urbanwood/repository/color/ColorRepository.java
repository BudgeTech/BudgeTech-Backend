package br.sc.senac.urbanwood.repository.color;

import br.sc.senac.urbanwood.model.color.Color;
import br.sc.senac.urbanwood.projection.color.ColorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<ColorProjection> findColorById(Long id);

    List<ColorProjection> findColorByNameColor(String nameColor);

    List<ColorProjection> findColorByBrand(String brand);
}
