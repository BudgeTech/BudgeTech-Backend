package br.sc.senac.urbanwood.controller.order;

import br.sc.senac.urbanwood.dto.order.OrderCreateDTO;
import br.sc.senac.urbanwood.dto.order.OrderDTO;
import br.sc.senac.urbanwood.projection.order.OrderProjection;
import br.sc.senac.urbanwood.projection.order.screen.OrderProjectionW12;
import br.sc.senac.urbanwood.projection.order.screen.OrderProjectionW13;
import br.sc.senac.urbanwood.service.order.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@RequestBody OrderCreateDTO orderCreateDTO, @PathVariable(value = "id") Long id) {
        orderService.update(orderCreateDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Order updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(value = "id") Long id) {
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
    }

    @GetMapping("initialDate/{initialDate}")
    public ResponseEntity<List<OrderProjection>> getProjectionByInitialDate(@PathVariable(value = "initialDate") String initialDate) {
        LocalDate data = LocalDate.parse(initialDate);
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findByInitialDate(data));
    }

    /*          |||
      Screen    |||
      Screen    |||
      Screen    vvv
     */

    //Approved
    @GetMapping("w12/{page}")
    public ResponseEntity<Page<OrderProjectionW12>> getProjectionW12OrderByInitialDate(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findW12OrderByInitialDate(pageable, page));
    }

    //Approved
    @GetMapping("w13/{id}")
    public ResponseEntity<OrderProjectionW13> getProjectionW13ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findW13ById(id));
    }
}
