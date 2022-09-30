package br.sc.senac.urbanwood.backend.urbanwood;

import org.junit.jupiter.api.Test;

import br.sc.senac.urbanwood.backend.model.Furniture;
import br.sc.senac.urbanwood.backend.model.Request;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestTest {


    @Test
    void TestOfCalculating() {
        var fun1 = new Furniture(1L, "nome", "descrição", 15.50, 2);
        var fun2 = new Furniture(1L, "nome", "descrição", 15.50, 2);
        var fun3 = new Furniture(1L, "nome", "descrição", 15.50, 2);

        var request = new Request();
        request.addFurniture(fun1);
        request.addFurniture(fun2);
        request.addFurniture(fun3);

        assertEquals(6, request.calculationPrice());
    }

    @Test
    void TestOfCalculating2() {
        var fun1 = new Furniture(1L, "nome", "descrição", 15.50, 18);
        var fun2 = new Furniture(1L, "nome", "descrição", 15.50, 2);
        var fun3 = new Furniture(1L, "nome", "descrição", 15.50, 15);

        var request = new Request();
        request.addFurniture(fun1);
        request.addFurniture(fun2);
        request.addFurniture(fun3);

        assertEquals(35, request.calculationPrice());
    }
}
