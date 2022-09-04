package br.sc.senac.budgetech.backend.service.request;

import br.sc.senac.budgetech.backend.dto.RequestCreateDTO;
import br.sc.senac.budgetech.backend.dto.RequestDTO;
import br.sc.senac.budgetech.backend.projection.RequestProjection;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface RequestService {

    RequestDTO save(RequestCreateDTO requestListDTO);

    void update(RequestDTO requestDTO, Long id);

    void delete(Long id);

    RequestProjection findById(Long id);

    RequestProjection findByInitialDate(LocalDate initialDate);
}
