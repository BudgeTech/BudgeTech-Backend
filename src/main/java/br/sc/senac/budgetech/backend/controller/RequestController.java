package br.sc.senac.budgetech.backend.controller;

import br.sc.senac.budgetech.backend.dto.RequestCreateDTO;
import br.sc.senac.budgetech.backend.dto.RequestDTO;
import br.sc.senac.budgetech.backend.projection.RequestProjection;
import br.sc.senac.budgetech.backend.service.request.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/request")
@AllArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestDTO> addRequest(@RequestBody RequestCreateDTO requestListDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(requestService.save(requestListDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRequest(@RequestBody RequestDTO requestDTO, @PathVariable(value = "id") Long id) {
        requestService.update(requestDTO, id);
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
    public ResponseEntity<RequestProjection> getProjectionByInitialDate(@PathVariable(value = "initialDate") LocalDate initialDate) {
        return ResponseEntity.status(HttpStatus.OK).body(requestService.findByInitialDate(initialDate));
    }
}
