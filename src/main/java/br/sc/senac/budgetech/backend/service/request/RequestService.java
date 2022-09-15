package br.sc.senac.budgetech.backend.service.request;

import br.sc.senac.budgetech.backend.dto.request.*;
import br.sc.senac.budgetech.backend.projection.request.RequestListProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProfileProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface RequestService {

    RequestDTO save(RequestCreateDTO requestCreateDTO);

    void update(RequestCreateDTO requestCreateDTO, Long id);

    void delete(Long id);

    RequestProjection findById(Long id);

    RequestProjection findByInitialDate(LocalDate initialDate);

    RequestProfileProjection findProfileById(Long id);

    List<RequestListProjection> findListById(Long id);

    RequestWithFurnituresProjection findFurnitureById(Long id);
}
