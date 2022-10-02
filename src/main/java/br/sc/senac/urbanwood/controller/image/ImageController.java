package br.sc.senac.urbanwood.controller.image;


import br.sc.senac.urbanwood.model.image.ImageModel;
import br.sc.senac.urbanwood.repository.image.ImageRepository;
import br.sc.senac.urbanwood.service.image.ImageService;
import br.sc.senac.urbanwood.util.ImageUtil;
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
public class ImageController {

    private final ImageRepository imageRepository;
    private final ImageService imageService;

    public ImageController(ImageRepository imageRepository, ImageService imageService) {
        this.imageRepository = imageRepository;
        this.imageService = imageService;
    }

    @PostMapping
    public BodyBuilder uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

        //System.out.println("Original Image Byte Size - " + file.getBytes().length);

        var img = new ImageUtil().createImageModel(file);
        imageRepository.save(img);
        return ResponseEntity.status(HttpStatus.OK);
    }

//    @PutMapping
//    public BodyBuilder updateImage(@RequestParam("imageFile") MultipartFile file, @PathVariable(value = "id") Long id) throws IOException {
//
//        //System.out.println("Original Image Byte Size - " + file.getBytes().length);
//
//        var img = new ImageUtils().createImageModel(file);
//        imageRepository.save(img, id);
//        return ResponseEntity.status(HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable("id") Long id) {
        imageService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Image deleted successfully");
    }

    @GetMapping("/{id}")
    public ImageModel getImageById(@PathVariable("id") Long id) {
        final Optional<ImageModel> retrievedImage = imageRepository.findImageById(id);
        ImageModel img = new ImageModel(retrievedImage.get().getId(), retrievedImage.get().getName(), retrievedImage.get().getType(),
                ImageUtil.decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    @GetMapping("/name/{imageName}")
    public ImageModel getImageByName(@PathVariable("imageName") String imageName) {
        final Optional<ImageModel> retrievedImage = imageRepository.findImageByName(imageName);

        ImageModel img = new ImageModel(retrievedImage.get().getId(), retrievedImage.get().getName(), retrievedImage.get().getType(),
                ImageUtil.decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }
}