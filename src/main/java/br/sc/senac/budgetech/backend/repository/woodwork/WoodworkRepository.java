package br.sc.senac.budgetech.backend.repository.woodwork;

import br.sc.senac.budgetech.backend.model.woodwork.Woodwork;
import br.sc.senac.budgetech.backend.projection.woodwork.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WoodworkRepository extends JpaRepository<Woodwork, Long> {

    boolean existsByCnpj(String cnpj);

    boolean existsByLogin(String login);

    Optional<WoodworkProjection> findWoodworkById(Long id);

    Optional<WoodworkProjection> findWoodworkByCompanyName(String companyName);

    Optional<WoodworkProjection> findWoodworkByAddressNeighborhood(String neighborhood);

    Optional<WoodworkProjection> findWoodworkByContactPhoneNumber(String phoneNumber);

    Optional<WoodworkProjection> findWoodworkByCnpj(String cnpj);

    Optional<WoodworkProjection> findWoodworkByLogin(String login);

    List<WoodworkSearchProjectionC9> findWoodworkSearchBy();

    Optional<WoodworkProfileProjectionC8AndC10> findWoodworkProfileBy();

    Optional<WoodworkFulProjection21> findWoodworkFull21By();

    //Optional<WoodworkProfileEditProjection> findWoodworkProfileEditBy();

    //Optional<WoodworkProfileFullEditProjection> findWoodworkProfileFullEditBy();
}
