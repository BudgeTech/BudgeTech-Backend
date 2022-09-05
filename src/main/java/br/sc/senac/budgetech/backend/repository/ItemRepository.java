package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Item;
import br.sc.senac.budgetech.backend.projection.ItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<ItemProjection> findItemById(Long id);

    Optional<ItemProjection> findItemByTotalPrice(double totalPrice);
}
