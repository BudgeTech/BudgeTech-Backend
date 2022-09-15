package br.sc.senac.budgetech.backend.controller.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.backend.service.furniture.FurnitureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(value = "/image")
    public ResponseEntity<FurnitureDTO> testAddImage(FurnitureDTO furnitureDTO, @RequestParam(value = "image") MultipartFile file) {
        return ResponseEntity.status(HttpStatus.CREATED).body(furnitureService.save(furnitureDTO));
    }

    @GetMapping
    public ResponseEntity<List<FurnitureListProjection>> testShowImage(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findListById(id));
    }

//    @PostMapping("/arquivo")
//    public ResponseEntity<FurnitureDTO> salvarArquivo(@RequestParam("file") MultipartFile file, FurnitureDTO furnitureDTO) {
//        log.info("Recebendo o arquivo: ", file.getOriginalFilename());
//        var caminho = UUID.randomUUID() + "." + extrairExtensao(file.getOriginalFilename());
//
//        log.info("Novo nome do arquivo: " + caminho);
//
//        try {
//            Files.copy(file.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);
//            return ResponseEntity.status(HttpStatus.CREATED).body(furnitureService.save(furnitureDTO, file));
//        } catch (Exception e) {
//            log.error("Erro ao processar arquivo", e);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }
//
//    private String extrairExtensao(String nomeArquivo) {
//        int i = nomeArquivo.lastIndexOf(".");
//        return nomeArquivo.substring(i + 1);
//    }

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
    public ResponseEntity<FurnitureProjection> getProjectionByPrice(@PathVariable(value = "priceFurniture") Double priceFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByPriceFurniture(priceFurniture));
    }

    @GetMapping("priceList/{priceFurniture}")
    public ResponseEntity<List<FurnitureProjection>> getProjectionListByPrice(@PathVariable(value = "priceFurniture") Double priceFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findListByPriceFurniture(priceFurniture));
    }

    @GetMapping("furnitureList/{id}")
    public ResponseEntity<List<FurnitureListProjection>> getProjectionListById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findListById(id));
    }

    @GetMapping("paginationChosen/{offset}/{pageSize}/{field}")
    public ResponseEntity<Page<Furniture>> getProjectionWithPaginationAndSortingChosen(@PathVariable(value = "offset") int offset, @PathVariable(value = "pageSize") int pageSize, @PathVariable(value = "field") String field) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findWithPaginationAndSorting(offset, pageSize, field));
    }

    @GetMapping("paginationPrice/{page}")
    public ResponseEntity<Page<FurnitureListProjection>> getProjectionWithPaginationAndSortingByPrice(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findWithPaginationAndSortingByPriceFurniture(pageable, page));
    }

    @GetMapping("paginationName/{page}")
    public ResponseEntity<Page<FurnitureListProjection>> getProjectionWithPaginationAndSortingByName(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findWithPaginationAndSortingByNameFurniture(pageable, page));
    }
}