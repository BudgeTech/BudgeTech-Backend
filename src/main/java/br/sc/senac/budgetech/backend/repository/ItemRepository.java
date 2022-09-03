package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Item;
import br.sc.senac.budgetech.backend.projection.ItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<ItemProjection> findItemById(Long id);

    Optional<ItemProjection> findItemByTotalPrice(double totalPrice);
}
