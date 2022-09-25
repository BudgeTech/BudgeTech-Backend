package br.sc.senac.budgetech.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.budgetech.backend.model.Image;
import br.sc.senac.budgetech.backend.projection.image.ImageProjection;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	
	Optional<ImageProjection> findByName(String name);

}
