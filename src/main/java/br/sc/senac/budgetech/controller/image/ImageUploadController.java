package br.sc.senac.budgetech.controller.image;


import br.sc.senac.budgetech.exception.image.ImageNotFoundException;
import br.sc.senac.budgetech.model.image.ImageModel;
import br.sc.senac.budgetech.repository.image.ImageRepository;
import br.sc.senac.budgetech.util.ImageCompressAndDecompress;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/image")
public class ImageUploadController {

    private final ImageRepository imageRepository;

    public ImageUploadController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @PostMapping
    public BodyBuilder uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
                ImageCompressAndDecompress.compressBytes(file.getBytes()));
        imageRepository.save(img);
        return ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ImageModel getImageById(@PathVariable("id") Long id) {
        final Optional<ImageModel> retrievedImage = imageRepository.findImageById(id);

        ImageModel img = new ImageModel(retrievedImage.get().getId(), retrievedImage.get().getName(), retrievedImage.get().getType(),
                ImageCompressAndDecompress.decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    @GetMapping("/name/{imageName}")
    public ImageModel getImageByName(@PathVariable("imageName") String imageName) {
        final Optional<ImageModel> retrievedImage = imageRepository.findImageByName(imageName);

        ImageModel img = new ImageModel(retrievedImage.get().getId(), retrievedImage.get().getName(), retrievedImage.get().getType(),
                ImageCompressAndDecompress.decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }
}