package br.sc.senac.urbanwood.repository.woodwork;

import br.sc.senac.urbanwood.model.contact.Contact;
import br.sc.senac.urbanwood.model.woodwork.Woodwork;
import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;
import br.sc.senac.urbanwood.projection.woodwork.filter.WoodworkProjectionFilter;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC8;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC9;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW6;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WoodworkRepository extends JpaRepository<Woodwork, Long> {

    boolean existsByCnpj(String cnpj);

    boolean existsByLogin(String login);

    Optional<WoodworkProjection> findWoodworkById(Long id);


    //Filters
    List<WoodworkProjectionFilter> findWoodworkByCompanyName(String companyName);

    List<WoodworkProjectionFilter> findWoodworkByAddressNeighborhood(String neighborhood);

    Optional<WoodworkProjectionFilter> findWoodworkByCnpj(String cnpj);

    @Query(value = """
            select w.image as image from Woodwork w
            join Contact co on w.id = co.id
            where co.phoneNumber = :co.phoneNumber
            """)
    Optional<WoodworkProjectionFilter> findWoodworkByContactPhoneNumber(String phoneNumber);

    //Screens
    Optional<WoodworkProjectionC8> findWoodworkC8ById(Long id);

    List<WoodworkProjectionC9> findWoodworkC9ByCompanyName(String companyName);

    Optional<WoodworkProjectionW6> findWoodworkW6ById(Long id);
    Optional<WoodworkProjectionW7> findWoodworkW7ById(Long id);
}
