package br.sc.senac.budgetech.backend.controller.request;

import br.sc.senac.budgetech.backend.dto.request.RequestCreateDTO;
import br.sc.senac.budgetech.backend.dto.request.RequestDTO;
import br.sc.senac.budgetech.backend.projection.request.RequestListProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProfileProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestProjection;
import br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection;
import br.sc.senac.budgetech.backend.service.request.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/request")
@AllArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestDTO> addRequest(@RequestBody RequestCreateDTO requestCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(requestService.save(requestCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRequest(@RequestBody RequestCreateDTO requestCreateDTO, @PathVariable(value = "id") Long id) {
        requestService.update(requestCreateDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Request updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable(value = "id") Long id) {
        requestService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Request deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(requestService.findById(id));
    }

    @GetMapping("initialDate/{initialDate}")
    public ResponseEntity<RequestProjection> getProjectionByInitialDate(@PathVariable(value = "initialDate") String initialDate) {
        LocalDate data = LocalDate.parse(initialDate);
        return ResponseEntity.status(HttpStatus.OK).body(requestService.findByInitialDate(data));
    }

    @GetMapping("requestProfile/{id}")
    public ResponseEntity<RequestProfileProjection> getProjectionRequestProfileById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(requestService.findProfileById(id));
    }

    @GetMapping("requestList/{id}")
    public ResponseEntity<List<RequestListProjection>> getProjectionRequestListById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(requestService.findListById(id));
    }

    @GetMapping("requestFurniture/{id}")
    public ResponseEntity<RequestWithFurnituresProjection> getProjectionRequestWithFurnitureById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(requestService.findFurnitureById(id));
    }
}
