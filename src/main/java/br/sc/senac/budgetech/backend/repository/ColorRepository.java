package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<Color> findColorById(Long id);

    Optional<Color> findColorByName(String name);

    Optional<Color> findColorByBrand(String brand);
}
