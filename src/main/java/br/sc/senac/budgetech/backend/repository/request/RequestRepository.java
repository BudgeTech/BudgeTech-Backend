package br.sc.senac.budgetech.backend.repository.request;

import br.sc.senac.budgetech.backend.model.request.Request;
import br.sc.senac.budgetech.backend.projection.request.RequestListProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProfileProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Optional<RequestProjection> findRequestByInitialDate(LocalDate initialDate);

    Optional<RequestProjection> findRequestById(Long id);

    //DTOS  ||
    //      ||
    //      vv

    List<RequestListProjection> findRequestListById(Long id);

    Optional<RequestProfileProjection> findRequestProfileById(Long id);

    Optional<RequestWithFurnituresProjection> findRequestWithFurnituresById(Long id);
}
