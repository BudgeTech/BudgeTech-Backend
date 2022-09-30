package br.sc.senac.urbanwood.repository.woodwork;

import br.sc.senac.urbanwood.model.woodwork.Woodwork;
import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC8;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC9;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW6;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WoodworkRepository extends JpaRepository<Woodwork, Long> {

    boolean existsByCnpj(String cnpj);

    boolean existsByLogin(String login);

    Optional<WoodworkProjection> findWoodworkById(Long id);

    List<WoodworkProjection> findWoodworkByCompanyName(String companyName);

    Optional<WoodworkProjection> findWoodworkByCnpj(String cnpj);

    //Screen

    Optional<WoodworkProjectionC8> findWoodworkC8ById(Long id);

    List<WoodworkProjectionC9> findWoodworkC9ByCompanyName(String companyName);

    Optional<WoodworkProjectionW6> findWoodworkW6ById(Long id);
    Optional<WoodworkProjectionW7> findWoodworkW7ById(Long id);
}
