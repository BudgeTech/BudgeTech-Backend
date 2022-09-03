package br.sc.senac.budgetech.backend.service.request;

import br.sc.senac.budgetech.backend.dto.RequestCreateDTO;
import br.sc.senac.budgetech.backend.dto.RequestListDTO;
import br.sc.senac.budgetech.backend.exception.request.RequestNotFoundException;
import br.sc.senac.budgetech.backend.mapper.RequestMapper;
import br.sc.senac.budgetech.backend.model.Request;
import br.sc.senac.budgetech.backend.projection.RequestProjection;
import br.sc.senac.budgetech.backend.repository.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;
    private FurnitureRepository furnitureRepository;
    private RequestMapper requestMapper;

    public RequestListDTO save(RequestCreateDTO requestListDTO) {

        Request request = new Request(requestListDTO.id(), requestListDTO.price(),
                requestListDTO.status(), requestListDTO.payment(),
                requestListDTO.initialDate(), requestListDTO.finalDate());

        for (Long idFurniture:requestListDTO.idsFunitures()) {
            var furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new RequestNotFoundException("Request " + idFurniture + " was not found"));
            request.getFurnitures().add(furniture);
        }

        Request requestSaved = requestRepository.save(request);

        return requestMapper.toDTO(requestSaved);
    }

    public void update(RequestListDTO requestListDTO, Long id) {

        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new RequestNotFoundException("Request " + id + " was not found"));

        request.setPrice(requestListDTO.price());
        request.setStatus(requestListDTO.status());
        request.setPayment(requestListDTO.payment());
        request.setInitialDate(requestListDTO.initialDate());
        request.setFinalDate(requestListDTO.finalDate());
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
