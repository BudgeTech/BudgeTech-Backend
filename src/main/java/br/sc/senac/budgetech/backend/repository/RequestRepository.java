package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Request;
import br.sc.senac.budgetech.backend.projection.RequestBasicProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

    Optional<RequestBasicProjection> findRequestByInitialDate(LocalDate initialDate);

}
