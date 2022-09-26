package br.sc.senac.urbanwood.backend.repository;

import br.sc.senac.urbanwood.backend.model.Woodwork;
import br.sc.senac.urbanwood.backend.projection.woodwork.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WoodworkRepository extends JpaRepository<Woodwork, Long> {

    boolean existsByCnpj(String cnpj);

    boolean existsByLogin(String login);

    Optional<WoodworkProjection> findWoodworkById(Long id);

    Optional<WoodworkProfileProjection> findWoodworkProfileById(Long id);

    Optional<WoodworkProfileEditProjection> findWoodworkProfileEditById(Long id);

    Optional<WoodworkProfileFullEditProjection> findWoodworkProfileFullEditById(Long id);

    Optional<WoodworkProjection> findWoodworkByCompanyName(String companyName);

    Optional<WoodworkProjection> findWoodworkByAddressNeighbor(String neighbor);

    Optional<WoodworkProjection> findWoodworkByContactPhoneNumber(String phoneNumber);

    Optional<WoodworkProjection> findWoodworkByCnpj(String cnpj);

    Optional<WoodworkProjection> findWoodworkByLogin(String login);

    Optional<WoodworkWithAddressAndContactProjection> findWoodworkWithAddressAndContactById(Long id);

}
