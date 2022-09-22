package br.sc.senac.budgetech.backend.repository.livingArea;

import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import br.sc.senac.budgetech.backend.projection.livingArea.LivingAreaProjectionC16andW16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivingAreaRepository extends JpaRepository<LivingArea, Long> {

    Optional<LivingAreaProjectionC16andW16> findLivingAreaById(Long id);

    Optional<LivingAreaProjectionC16andW16> findLivingAreaByNameLivingArea(String nameLivingArea);
}
