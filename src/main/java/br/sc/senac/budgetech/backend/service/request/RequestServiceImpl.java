package br.sc.senac.budgetech.backend.service.request;

import br.sc.senac.budgetech.backend.dto.RequestDTO;
import br.sc.senac.budgetech.backend.mapper.RequestMapper;
import br.sc.senac.budgetech.backend.projection.RequestBasicProjection;
import br.sc.senac.budgetech.backend.repository.ClientRepository;
import br.sc.senac.budgetech.backend.repository.RequestRepository;
import br.sc.senac.budgetech.backend.repository.WoodworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;
    private RequestMapper requestMapper;
    private WoodworkRepository woodworkRepository;
    private ClientRepository clientRepository;

    @Override
    public RequestDTO save(RequestDTO requestDTO) {
        return null;
    }

    @Override
    public void update(RequestDTO requestDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public RequestBasicProjection findById(Long id) {
        return null;
    }
}
