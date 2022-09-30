package br.sc.senac.urbanwood.controller.woodwork;

import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;
import br.sc.senac.urbanwood.projection.woodwork.filter.WoodworkProjectionFilter;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC8;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionC9;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW6;
import br.sc.senac.urbanwood.projection.woodwork.screen.WoodworkProjectionW7;
import br.sc.senac.urbanwood.service.woodwork.WoodworkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/woodwork")
public class WoodworkController {

    private final WoodworkService woodworkService;

    public WoodworkController(WoodworkService woodworkService) {
        this.woodworkService = woodworkService;
    }

    @PostMapping
    public ResponseEntity<WoodworkDTO> addWoodwork(@RequestBody WoodworkDTO woodworkDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(woodworkService.save(woodworkDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWoodwork(@RequestBody WoodworkDTO woodworkDTO, @PathVariable(value = "id") Long id) {
        woodworkService.update(woodworkDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Woodwork updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWoodwork(@PathVariable(value = "id") Long id) {
        woodworkService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Woodwork deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<WoodworkProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findById(id));
    }


    /*           |||
      Filters    |||
      Filters    |||
      Filters    vvv
     */

    @GetMapping("cnpj/{cnpj}")
    public ResponseEntity<WoodworkProjectionFilter> getProjectionByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByCnpj(cnpj));
    }

    @GetMapping("name/{companyName}")
    public ResponseEntity<List<WoodworkProjectionFilter>> getProjectionByCompanyName(@PathVariable(value = "companyName") String companyName) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByCompanyName(companyName));
    }

    @GetMapping("neighborhood/{neighborhood}")
    public ResponseEntity<List<WoodworkProjectionFilter>> getProjectionByNeighborhood(@PathVariable(value = "neighborhood") String neighborhood) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByNeighborhood(neighborhood));
    }

    //Funciona, MAS retorna ID
    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<WoodworkProjectionFilter> getProjectionByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByPhoneNumber(phoneNumber));
    }

    /*          |||
      Screen    |||
      Screen    |||
      Screen    vvv
     */

    //Approved
    @GetMapping("c8/{id}")
    public ResponseEntity<WoodworkProjectionC8> getProjectionC8ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findC8ById(id));
    }

    //Approved
    @GetMapping("c9/{companyName}")
    public ResponseEntity<List<WoodworkProjectionC9>> getProjectionC9ByCompanyName(@PathVariable(value = "companyName") String companyName) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findC9ByName(companyName));
    }

    //Approved
    @GetMapping("w6/{id}")
    public ResponseEntity<WoodworkProjectionW6> getProjectionW6ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findW6ById(id));
    }

    //Approved
    @GetMapping("w7/{id}")
    public ResponseEntity<WoodworkProjectionW7> getProjectionW7ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findW7ById(id));
    }
}