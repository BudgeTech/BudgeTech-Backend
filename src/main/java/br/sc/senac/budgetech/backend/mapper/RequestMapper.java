package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.RequestListDTO;
import br.sc.senac.budgetech.backend.model.Request;
import org.springframework.stereotype.Service;

@Service
public class RequestMapper {

    public RequestListDTO toDTO(Request request) {
        return new RequestListDTO(request.getId(), request.getPrice(), request.getStatus(), request.getPayment(), request.getInitialDate(), request.getFinalDate());
    }
}
