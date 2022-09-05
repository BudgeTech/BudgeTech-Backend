package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.RequestDTO;
import br.sc.senac.budgetech.backend.model.Request;
import org.springframework.stereotype.Service;

@Service
public class RequestMapper {

    public RequestDTO toDTO(Request request) {
        return new RequestDTO(request.getId(), request.getPrice(), request.getStatus(), request.getPayment(), request.getInitialDate(), request.getFinalDate());
    }
}
