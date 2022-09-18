package br.sc.senac.budgetech.backend.mapper.request;

import br.sc.senac.budgetech.backend.dto.request.RequestCreateDTO;
import br.sc.senac.budgetech.backend.dto.request.RequestDTO;
import br.sc.senac.budgetech.backend.model.request.Request;
import org.springframework.stereotype.Service;

@Service
public class RequestMapper {

    public RequestDTO toDTO(Request request) {
        return new RequestDTO(request.getId(), request.getPriceRequest(), request.getStatus(), request.getPayment(), request.getInitialDate(), request.getFinalDate());
    }

    public Request toEntity(RequestCreateDTO dto) {
        return new Request(dto.id(), dto.priceRequest(),
                dto.status(), dto.payment(),
                dto.initialDate(), dto.finalDate());
    }
}
