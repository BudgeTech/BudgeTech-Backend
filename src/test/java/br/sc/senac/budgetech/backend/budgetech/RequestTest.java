package br.sc.senac.budgetech.backend.budgetech;

import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.model.request.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestTest {


    @Test
    void TestOfCalculating() {
        var fun1 = new Furniture(1L, "nome", "descrição", 15.50, 2D);
        var fun2 = new Furniture(1L, "nome", "descrição", 15.50, 2D);
        var fun3 = new Furniture(1L, "nome", "descrição", 15.50, 2D);

        var request = new Request();
        request.addFurniture(fun1);
        request.addFurniture(fun2);
        request.addFurniture(fun3);

        assertEquals(6, request.calculationPrice());
    }

    @Test
    void TestOfCalculating2() {
        var fun1 = new Furniture(1L, "nome", "descrição", 15.50, 18D);
        var fun2 = new Furniture(1L, "nome", "descrição", 15.50, 2D);
        var fun3 = new Furniture(1L, "nome", "descrição", 15.50, 15D);

        var request = new Request();
        request.addFurniture(fun1);
        request.addFurniture(fun2);
        request.addFurniture(fun3);

        assertEquals(35, request.calculationPrice());
    }
}
