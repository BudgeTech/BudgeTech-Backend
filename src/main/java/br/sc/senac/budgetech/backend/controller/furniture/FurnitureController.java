package br.sc.senac.budgetech.backend.controller.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureListDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureScreenDTO;
import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.backend.service.furniture.FurnitureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/furniture")
@AllArgsConstructor
public class FurnitureController {

    private final FurnitureService furnitureService;

    @PostMapping
    public ResponseEntity<FurnitureDTO> addFurniture(@RequestBody FurnitureDTO furnitureDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(furnitureService.save(furnitureDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFurniture(@RequestBody FurnitureDTO furnitureDTO, @PathVariable(value = "id") Long id) {
        furnitureService.update(furnitureDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Furniture updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFurniture(@PathVariable(value = "id") Long id) {
        furnitureService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Furniture deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<FurnitureProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findById(id));
    }

    @GetMapping("name/{nameFurniture}")
    public ResponseEntity<FurnitureProjection> getProjectionByName(@PathVariable(value = "nameFurniture") String nameFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByNameFurniture(nameFurniture));
    }

    @GetMapping("price/{priceFurniture}")
    public ResponseEntity<FurnitureProjection> getProjectionByPrice(@PathVariable(value = "priceFurniture") double priceFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByPriceFurniture(priceFurniture));
    }

    @GetMapping("furnitureDTO/{id}")
    public ResponseEntity<FurnitureScreenDTO> getDtoById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByIdDTO(id));
    }

    @GetMapping("furnitureListDTO/{id}")
    public ResponseEntity<FurnitureListDTO> getListDtoById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findFurnitureListById(id));
    }

    @GetMapping("page/{page}")
    public ResponseEntity<Page<FurnitureListProjection>> getProjectionPage(@PathVariable(value = "page") Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findFurniture(page));
    }

    @GetMapping("page1/{page}")
    public ResponseEntity<FurnitureListDTO> getFurnitureDTO(@PathVariable(value = "page") Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findFurnitureDTO(page));
    }

    @GetMapping("test/{offset}/{pageSize}/{field}")
    public ResponseEntity<Page<Furniture>> getTest(@PathVariable(value = "offset") int offset, @PathVariable(value = "pageSize") int pageSize, @PathVariable(value = "field") String field) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findFurnitureWithPaginationAndSorting(offset, pageSize, field));
    }

//    @GetMapping("test/{page}")
//    public ResponseEntity<Page<FurnitureListProjection>> test(@PathVariable(value = "page") Integer page) {
//        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findFurnitureProjection(page));
//    }

    @GetMapping("test2/{page}")
    public ResponseEntity<Page<FurnitureListProjection>> test(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findFurnitureProjection(pageable, page));
    }

//    @GetMapping("test3/{page}")
//    public ResponseEntity<Page<FurnitureListDTO>> test2(@PathVariable(value = "page") Integer page, Pageable pageable) {
//        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findFurnitureDTOProjection(pageable, page));
//    }
}