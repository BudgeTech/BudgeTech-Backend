package br.sc.senac.urbanwood.service.image;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageService {

    void update (MultipartFile file, Long id) throws IOException;

    void delete(Long id);
}
