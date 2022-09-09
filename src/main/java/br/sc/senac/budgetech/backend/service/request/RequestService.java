package br.sc.senac.budgetech.backend.service.request;

import br.sc.senac.budgetech.backend.dto.request.RequestCreateDTO;
import br.sc.senac.budgetech.backend.dto.request.RequestDTO;
import br.sc.senac.budgetech.backend.projection.request.RequestProjection;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface RequestService {

    RequestDTO save(RequestCreateDTO requestCreateDTO);

    void update(RequestCreateDTO requestCreateDTO, Long id);

    void delete(Long id);

    RequestProjection findById(Long id);

    RequestProjection findByInitialDate(LocalDate initialDate);
}
