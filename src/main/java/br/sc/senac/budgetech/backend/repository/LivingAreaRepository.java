package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.LivingArea;
import br.sc.senac.budgetech.backend.projection.LivingAreaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivingAreaRepository extends JpaRepository<LivingArea, Long> {

    Optional<LivingAreaProjection> findLivingAreaById(Long id);

    Optional<LivingAreaProjection> findLivingAreaByName(String name);
}
