package br.sc.senac.budgetech.backend.service.request;

import br.sc.senac.budgetech.backend.dto.request.RequestCreateDTO;
import br.sc.senac.budgetech.backend.dto.request.RequestDTO;
import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.exception.request.RequestInvalidException;
import br.sc.senac.budgetech.backend.exception.request.RequestNotFoundException;
import br.sc.senac.budgetech.backend.mapper.request.RequestMapper;
import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.model.request.Request;
import br.sc.senac.budgetech.backend.projection.request.RequestListProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProfileProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection;
import br.sc.senac.budgetech.backend.repository.furniture.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.request.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;
    private FurnitureRepository furnitureRepository;
    private RequestMapper requestMapper;

    public RequestDTO save(RequestCreateDTO requestCreateDTO) {

        Request request = requestMapper.toEntity(requestCreateDTO);

        if (requestCreateDTO.priceRequest() < 0)
            throw new RequestInvalidException("Price " + requestCreateDTO.priceRequest() + " is invalid");

        request.setInitialDate(LocalDate.now());
        if(!request.getInitialDate().isBefore(requestCreateDTO.finalDate())) throw new RequestNotFoundException("Invalid Date " + requestCreateDTO.finalDate());

        for (Long idFurniture : requestCreateDTO.idFurnitures()) {
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new RequestNotFoundException("Furniture " + idFurniture + " was not found"));
            request.getFurnitures().add(furniture);
        }

        Request requestSaved = requestRepository.save(request);
        return requestMapper.toDTO(requestSaved);
    }

    public void update(RequestCreateDTO requestCreateDTO, Long id) {

        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new RequestNotFoundException("Request " + id + " was not found"));

        if (requestCreateDTO.priceRequest() < 0)
            throw new RequestInvalidException("Price " + requestCreateDTO.priceRequest() + " is invalid");

        for (Long idFurniture : requestCreateDTO.idFurnitures()) {
            request.setFurnitures(new ArrayList<>());
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new RequestNotFoundException("Request " + idFurniture + " was not found"));
            request.getFurnitures().add(furniture);
        }

        if(!request.getInitialDate().isBefore(requestCreateDTO.finalDate())) throw new RequestNotFoundException("Invalid Date " + requestCreateDTO.finalDate());

        request.setPriceRequest(requestCreateDTO.priceRequest());
        request.setStatus(requestCreateDTO.status());
        request.setPayment(requestCreateDTO.payment());
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

    public RequestProfileProjection findProfileById(Long id) {
        return requestRepository.findRequestProfileById(id)
                .orElseThrow(() -> new RequestNotFoundException("Request " + id + " was not found"));
    }

    public List<RequestListProjection> findListById(Long id) {
        List<RequestListProjection> request = requestRepository.findRequestListById(id);
        if(request.isEmpty())
            throw new RequestNotFoundException("Request " + id + " was not found");
        return request;
    }

    public RequestWithFurnituresProjection findFurnitureById(Long id) {
        return requestRepository.findRequestWithFurnituresById(id)
                .orElseThrow(() -> new RequestNotFoundException("Request " + id + " was not found"));
    }
}
