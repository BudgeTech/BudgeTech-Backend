package br.sc.senac.budgetech.repository.image;

import br.sc.senac.budgetech.model.image.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    Optional<ImageModel> findById(Long id);

    Optional<ImageModel> findByName(String name);
}