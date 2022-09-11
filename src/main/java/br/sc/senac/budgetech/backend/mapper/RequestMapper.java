package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.request.RequestDTO;
import br.sc.senac.budgetech.backend.dto.request.RequestListDTO;
import br.sc.senac.budgetech.backend.dto.request.RequestProfileDTO;
import br.sc.senac.budgetech.backend.dto.request.RequestWithFurnituresDTO;
import br.sc.senac.budgetech.backend.model.Request;
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

    public RequestProfileDTO toDTO(RequestProfileProjection request) {
        return new RequestProfileDTO(request.getId(), request.getPriceRequest(), request.getInitialDate(), request.getFurniture(), request.getItem().getClient().getNameClient(), request.getItem().getClient().getCpf(), request.getItem().getClient().getContact().getEmail(), request.getItem().getClient().getContact().getPhoneNumber(), request.getItem().getClient().getAddress().getNumber(), request.getItem().getClient().getAddress().getNeighborhood(), request.getItem().getClient().getAddress().getCity(), request.getItem().getClient().getAddress().getCep());
    }

    public RequestWithFurnituresDTO toDTO(RequestWithFurnituresProjection request) {
        return new RequestWithFurnituresDTO(request.getFurniture());
    }

    public RequestListDTO toDTO(List<RequestListProjection> requests) {
        return new RequestListDTO(requests);
    }
}
