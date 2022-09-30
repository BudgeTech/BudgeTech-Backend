package br.sc.senac.budgetech.repository.image;

import br.sc.senac.budgetech.model.image.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    Optional<ImageModel> findImageById(Long id);

    Optional<ImageModel> findImageByName(String name);
}