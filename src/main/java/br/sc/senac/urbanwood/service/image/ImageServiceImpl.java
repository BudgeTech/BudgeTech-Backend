package br.sc.senac.urbanwood.service.image;

import br.sc.senac.urbanwood.exception.image.ImageNotFoundException;
import br.sc.senac.urbanwood.model.image.ImageModel;
import br.sc.senac.urbanwood.repository.image.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void update(MultipartFile file, Long id) throws IOException {

        ImageModel imageModel = imageRepository.findById(id)
                .orElseThrow(() -> new ImageNotFoundException("Image " + id + " was not found"));



//        imageModel = new ImageUtils().createImageModel(file);
        imageRepository.save(imageModel);
    }

    public void delete(Long id) {
        if (!imageRepository.existsById(id)) throw new ImageNotFoundException("Image " + id + " was not found");
        imageRepository.deleteById(id);
    }
}
