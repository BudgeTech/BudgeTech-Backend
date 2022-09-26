package br.sc.senac.urbanwood.backend.service.request;

import br.sc.senac.urbanwood.backend.dto.request.*;
import br.sc.senac.urbanwood.backend.projection.request.RequestProjection;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface RequestService {

    RequestDTO save(RequestCreateDTO requestCreateDTO);

    void update(RequestCreateDTO requestCreateDTO, Long id);

    void delete(Long id);

    RequestProjection findByInitialDate(LocalDate initialDate);

    RequestProjection findById(Long id);

    //DTOS  ||
    //      ||
    //      vv

    RequestProfileDTO findRequestProfileById(Long id);

    RequestList2DTO findRequestListById(Long id);

    RequestWithFurnituresDTO findRequestWithFurnituresById(Long id);
}
