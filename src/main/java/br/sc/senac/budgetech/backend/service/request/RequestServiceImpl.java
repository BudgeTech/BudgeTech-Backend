package br.sc.senac.budgetech.backend.service.request;

import br.sc.senac.budgetech.backend.dto.request.RequestCreateDTO;
import br.sc.senac.budgetech.backend.dto.request.RequestDTO;
import br.sc.senac.budgetech.backend.exception.item.ItemInvalidException;
import br.sc.senac.budgetech.backend.exception.request.RequestInvalidException;
import br.sc.senac.budgetech.backend.exception.request.RequestNotFoundException;
import br.sc.senac.budgetech.backend.mapper.RequestMapper;
import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.model.Request;
import br.sc.senac.budgetech.backend.projection.request.RequestProfileProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProjection;
import br.sc.senac.budgetech.backend.repository.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;
    private FurnitureRepository furnitureRepository;
    private RequestMapper requestMapper;

    public RequestDTO save(RequestCreateDTO requestCreateDTO) {

        Request request = new Request(requestCreateDTO.id(), requestCreateDTO.priceRequest(),
                requestCreateDTO.status(), requestCreateDTO.payment(),
                requestCreateDTO.initialDate(), requestCreateDTO.finalDate());

        for (Long idFurniture : requestCreateDTO.idsFurnitures()) {
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new RequestNotFoundException("Furniture " + idFurniture + " was not found"));
            request.getFurnitures().add(furniture);
        }

        if (requestCreateDTO.priceRequest() < 0)
            throw new ItemInvalidException("Price " + requestCreateDTO.priceRequest() + " is invalid");

        request.setInitialDate(LocalDate.now());
        Request requestSaved = requestRepository.save(request);
        return requestMapper.toDTO(requestSaved);
    }

    public void update(RequestCreateDTO requestCreateDTO, Long id) {

        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new RequestNotFoundException("Request " + id + " was not found"));

        if (requestCreateDTO.priceRequest() < 0)
            throw new RequestInvalidException("Price " + requestCreateDTO.priceRequest() + " is invalid");

        for (Long idFurniture : requestCreateDTO.idsFurnitures()) {
            request.setFurnitures(new ArrayList<>());
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new RequestNotFoundException("Request " + idFurniture + " was not found"));
            request.getFurnitures().add(furniture);
        }

        request.setPriceRequest(requestCreateDTO.priceRequest());
        request.setStatus(requestCreateDTO.status());
        request.setPayment(requestCreateDTO.payment());
        request.setInitialDate(requestCreateDTO.initialDate());
        request.setFinalDate(requestCreateDTO.finalDate());
        requestRepository.save(request);
    }

    public void delete(Long id) {
        if (!requestRepository.existsById(id))
            throw new RequestNotFoundException("Request " + id + " was not found");
        requestRepository.deleteById(id);
    }

    public RequestProjection findById(Long id) {
        return requestRepository.findRequestById(id)
                .orElseThrow(() -> new RequestNotFoundException("Request " + id + " was not found"));
    }

    public RequestProjection findByInitialDate(LocalDate initialDate) {
        return requestRepository.findRequestByInitialDate(initialDate)
                .orElseThrow(() -> new RequestNotFoundException("Request " + initialDate + " was not found"));
    }
}
