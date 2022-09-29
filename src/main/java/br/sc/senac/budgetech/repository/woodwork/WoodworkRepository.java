package br.sc.senac.budgetech.repository.woodwork;

import br.sc.senac.budgetech.model.woodwork.Woodwork;
import br.sc.senac.budgetech.projection.woodwork.WoodworkProjection;
import br.sc.senac.budgetech.projection.woodwork.screen.WoodworkProjectionC8;
import br.sc.senac.budgetech.projection.woodwork.screen.WoodworkProjectionC9;
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
}
