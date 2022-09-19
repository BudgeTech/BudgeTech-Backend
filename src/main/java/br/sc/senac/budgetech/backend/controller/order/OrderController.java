package br.sc.senac.budgetech.backend.controller.order;

import br.sc.senac.budgetech.backend.dto.order.OrderCreateDTO;
import br.sc.senac.budgetech.backend.dto.order.OrderDTO;
import br.sc.senac.budgetech.backend.projection.order.OrderListProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderProfileProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderProjection;
import br.sc.senac.budgetech.backend.projection.order.OrderWithFurnituresProjection;
import br.sc.senac.budgetech.backend.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

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
    public ResponseEntity<OrderProjection> getProjectionByInitialDate(@PathVariable(value = "initialDate") String initialDate) {
        LocalDate data = LocalDate.parse(initialDate);
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findByInitialDate(data));
    }

    @GetMapping("orderProfile/{id}")
    public ResponseEntity<OrderProfileProjection> getProjectionOrderProfileById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findProfileById(id));
    }

    @GetMapping("orderList/{id}")
    public ResponseEntity<List<OrderListProjection>> getProjectionOrderListById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findListById(id));
    }

    @GetMapping("orderFurniture/{id}")
    public ResponseEntity<OrderWithFurnituresProjection> getProjectionOrderWithFurnitureById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findFurnitureById(id));
    }
}
