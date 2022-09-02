package br.sc.senac.budgetech.backend.service.request;

import br.sc.senac.budgetech.backend.dto.RequestDTO;
import br.sc.senac.budgetech.backend.projection.RequestBasicProjection;
import org.springframework.stereotype.Service;

@Service
public interface RequestService {

    RequestDTO save(RequestDTO requestDTO);

    void update(RequestDTO requestDTO, Long id);

    void delete(Long id);

    RequestBasicProjection findById(Long id);
}
