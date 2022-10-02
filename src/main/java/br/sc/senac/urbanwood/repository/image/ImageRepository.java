package br.sc.senac.urbanwood.repository.image;

import br.sc.senac.urbanwood.model.image.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    Optional<ImageModel> findImageById(Long id);

    Optional<ImageModel> findImageByName(String name);
}