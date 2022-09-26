package br.sc.senac.budgetech.backend.repository.item;

import br.sc.senac.budgetech.backend.model.item.Item;
import br.sc.senac.budgetech.backend.projection.client.OrderProjectionW10;
import br.sc.senac.budgetech.backend.projection.item.ItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<ItemProjection> findItemById(Long id);

    List<ItemProjection> findItemByTotalPrice(Double totalPrice);

    @Query(value = """ 
            select o.id as id, o.initialDate as initialDate, o.priceOrder as priceOrder
            from Item i
            inner join Order o on i.order.id = o.id
            where i.client.id = ?1
            """)
    List<OrderProjectionW10> findIdOrderByIdClient(Long id);
}
