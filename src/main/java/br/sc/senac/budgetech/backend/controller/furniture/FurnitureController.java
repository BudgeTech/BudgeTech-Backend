package br.sc.senac.budgetech.backend.controller.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureWithColorProjectionC14andW15andW18;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjectionC15andW17;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.backend.service.furniture.FurnitureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/furniture")
@Slf4j
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
    public ResponseEntity<List<FurnitureProjection>> getProjectionByName(@PathVariable(value = "nameFurniture") String nameFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByNameFurniture(nameFurniture));
    }

    @GetMapping("price/{priceFurniture}")
    public ResponseEntity<List<FurnitureProjection>> getProjectionByPrice(@PathVariable(value = "priceFurniture") Double priceFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByPriceFurniture(priceFurniture));
    }

    @GetMapping("priceList/{priceFurniture}")
    public ResponseEntity<List<FurnitureProjection>> getProjectionListByPrice(@PathVariable(value = "priceFurniture") Double priceFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findListByPriceFurniture(priceFurniture));
    }

    @GetMapping("furnitureList/{id}")
    public ResponseEntity<List<FurnitureListProjectionC15andW17>> getProjectionListById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findListById(id));
    }

    @GetMapping("paginationChosen/{offset}/{pageSize}/{field}")
    public ResponseEntity<Page<FurnitureListProjectionC15andW17>> getProjectionWithPaginationAndSortingChosen(@PathVariable(value = "offset") int offset, @PathVariable(value = "pageSize") int pageSize, @PathVariable(value = "field") String field) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findWithPaginationAndSorting(offset, pageSize, field));
    }

    @GetMapping("paginationPrice/{page}")
    public ResponseEntity<Page<FurnitureListProjectionC15andW17>> getProjectionWithPaginationAndSortingByPrice(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findWithPaginationAndSortingByPriceFurniture(pageable, page));
    }

    @GetMapping("paginationName/{page}")
    public ResponseEntity<Page<FurnitureListProjectionC15andW17>> getProjectionWithPaginationAndSortingByName(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findWithPaginationAndSortingByNameFurniture(pageable, page));
    }

    @GetMapping("paginationName-Five/{page}")
    public ResponseEntity<Page<FurnitureListProjectionC15andW17>> getProjectionWithPaginationAndSortingByNameW17(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findWithPaginationAndSortingByNameFurnitureW17(pageable, page));
    }

    @GetMapping("furnitureFull/{id}")
    public ResponseEntity<FurnitureWithColorProjectionC14andW15andW18> getProjectionByPrice(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findFurnitureById(id));
    }
}