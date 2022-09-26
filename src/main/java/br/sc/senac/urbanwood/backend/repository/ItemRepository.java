package br.sc.senac.urbanwood.backend.repository;

import br.sc.senac.urbanwood.backend.model.Item;
import br.sc.senac.urbanwood.backend.projection.item.ItemProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<ItemProjection> findItemById(Long id);

    Optional<ItemProjection> findItemByTotalPrice(double totalPrice);
}
