package br.sc.senac.budgetech.repository.living_area;

import br.sc.senac.budgetech.model.living_area.LivingArea;
import br.sc.senac.budgetech.projection.living_area.LivingAreaProjection;
import br.sc.senac.budgetech.projection.living_area.screen.LivingAreaProjectionC16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivingAreaRepository extends JpaRepository<LivingArea, Long> {

    Optional<LivingAreaProjection> findLivingAreaById(Long id);

    List<LivingAreaProjection> findLivingAreaByNameLivingArea(String nameLivingArea);

    //Screen

    @Query(value = """
            select l.nameLivingArea as nameLivingArea, l.image as image
            from LivingArea l
            order by l.nameLivingArea
            """)
    List<LivingAreaProjectionC16> findAllOrderByName();
}
