package br.sc.senac.budgetech.backend.repository.livingArea;

import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import br.sc.senac.budgetech.backend.projection.livingArea.LivingAreaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivingAreaRepository extends JpaRepository<LivingArea, Long> {

    Optional<LivingAreaProjection> findLivingAreaById(Long id);

    Optional<LivingAreaProjection> findLivingAreaByNameLivingArea(String nameLivingArea);
}
