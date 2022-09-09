package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Request;
import br.sc.senac.budgetech.backend.projection.request.RequestProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Optional<RequestProjection> findRequestByInitialDate(LocalDate initialDate);

    Optional<RequestProjection> findRequestById(Long id);

}
