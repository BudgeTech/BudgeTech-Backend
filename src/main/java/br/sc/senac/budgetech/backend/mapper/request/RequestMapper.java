package br.sc.senac.budgetech.backend.mapper.request;

import br.sc.senac.budgetech.backend.dto.request.RequestDTO;
import br.sc.senac.budgetech.backend.model.request.Request;
import br.sc.senac.budgetech.backend.projection.request.RequestListProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProfileProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestMapper {

    public RequestDTO toDTO(Request request) {
        return new RequestDTO(request.getId(), request.getPriceRequest(), request.getStatus(), request.getPayment(), request.getInitialDate(), request.getFinalDate());
    }
}
