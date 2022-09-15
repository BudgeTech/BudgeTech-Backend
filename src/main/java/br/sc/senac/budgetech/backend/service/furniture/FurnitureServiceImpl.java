package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureInvalidException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNameRegisteredException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.budgetech.backend.exception.livingarea.LivingAreaNotFoundException;
import br.sc.senac.budgetech.backend.mapper.furniture.FurnitureMapper;
import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.backend.repository.furniture.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.livingArea.LivingAreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;
    private final LivingAreaRepository livingAreaRepository;

    public FurnitureDTO save(FurnitureDTO furnitureDTO) {

        LivingArea livingArea = livingAreaRepository.findById(furnitureDTO.idLivingArea())
                .orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + furnitureDTO.idLivingArea() + " was not found"));

        if (furnitureRepository.existsByNameFurniture(furnitureDTO.nameFurniture()))
            throw new FurnitureNameRegisteredException("Furniture " + furnitureDTO.nameFurniture() + " is already registered");

        if (furnitureDTO.furnitureSize() <= 0)
            throw new FurnitureInvalidException("Furniture Size " + furnitureDTO.furnitureSize() + " is invalid");

        if (furnitureDTO.priceFurniture() < 0)
            throw new FurnitureInvalidException("Price " + furnitureDTO.priceFurniture() + " is invalid");

        Furniture furniture = furnitureMapper.toEntity(furnitureDTO);
        furniture.setLivingArea(livingArea);
        Furniture furnitureSaved = furnitureRepository.save(furniture);

        return furnitureMapper.toDTO(furnitureSaved);
    }

    public FurnitureDTO save(FurnitureDTO furnitureDTO, MultipartFile file) {

        LivingArea livingArea = livingAreaRepository.findById(furnitureDTO.idLivingArea())
                .orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + furnitureDTO.idLivingArea() + " was not found"));

        if (furnitureRepository.existsByNameFurniture(furnitureDTO.nameFurniture()))
            throw new FurnitureNameRegisteredException("Furniture " + furnitureDTO.nameFurniture() + " is already registered");

        if (furnitureDTO.furnitureSize() <= 0)
            throw new FurnitureInvalidException("Furniture Size " + furnitureDTO.furnitureSize() + " is invalid");

        if (furnitureDTO.priceFurniture() < 0)
            throw new FurnitureInvalidException("Price " + furnitureDTO.priceFurniture() + " is invalid");

        Furniture furniture = furnitureMapper.toEntity(furnitureDTO);
        furniture.setLivingArea(livingArea);

        try {
            furniture.setImage(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Furniture furnitureSaved = furnitureRepository.save(furniture);

        return furnitureMapper.toDTO(furnitureSaved);
    }

    public void update(FurnitureDTO furnitureDTO, Long id) {

        Furniture furniture = furnitureRepository.findById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Furniture " + id + " was not found"));

        if (furnitureRepository.existsByNameFurniture(furnitureDTO.nameFurniture()))
            throw new FurnitureNameRegisteredException("Name " + furnitureDTO.nameFurniture() + " is already registered");

        if (furnitureDTO.furnitureSize() <= 0)
            throw new FurnitureInvalidException("Furniture Size " + furnitureDTO.furnitureSize() + " is invalid");

        if (furnitureDTO.priceFurniture() < 0)
            throw new FurnitureInvalidException("Price " + furnitureDTO.priceFurniture() + " is invalid");

        furniture.setNameFurniture((furnitureDTO.nameFurniture() != null && !furnitureDTO.nameFurniture().isBlank()) ? furnitureDTO.nameFurniture() : furniture.getNameFurniture());
        furniture.setDescription((furnitureDTO.description() != null && !furnitureDTO.description().isBlank()) ? furnitureDTO.description() : furniture.getDescription());
        furniture.setFurnitureSize(furnitureDTO.furnitureSize());
        furniture.setPriceFurniture(furnitureDTO.priceFurniture());
        furnitureRepository.save(furniture);
    }

    public void delete(Long id) {
        if (!furnitureRepository.existsById(id))
            throw new FurnitureNotFoundException("Furniture " + id + " was not found");
        furnitureRepository.deleteById(id);
    }

    public FurnitureProjection findById(Long id) {
        return furnitureRepository.findFurnitureById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Id " + id + " was not found"));
    }

    public FurnitureProjection findByNameFurniture(String nameFurniture) {
        return furnitureRepository.findFurnitureByNameFurniture(nameFurniture)
                .orElseThrow(() -> new FurnitureNotFoundException("Name " + nameFurniture + " was not found"));
    }

    public FurnitureProjection findByPriceFurniture(Double priceFurniture) {
        return furnitureRepository.findFurnitureByPriceFurniture(priceFurniture)
                .orElseThrow(() -> new FurnitureNotFoundException("Price " + priceFurniture + " was not found"));
    }

    public List<FurnitureProjection> findListByPriceFurniture(Double priceFurniture) {
        List<FurnitureProjection> furniture = furnitureRepository.findFurnitureListByPriceFurniture(priceFurniture);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Furniture " + priceFurniture + " was not found");
        return furniture;
    }

    public List<FurnitureListProjection> findListById(Long id) {
        List<FurnitureListProjection> furniture = furnitureRepository.findFurnitureListById(id);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Furniture " + id + " was not found");
        return furniture;
    }

    public Page<Furniture> findWithPaginationAndSorting(int offset, int pageSize, String field) {
        return furnitureRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    }

    public Page<FurnitureListProjection> findWithPaginationAndSortingByPriceFurniture(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "priceFurniture");
        return furnitureRepository.findAllFurnitureBy(pageable);
    }

    public Page<FurnitureListProjection> findWithPaginationAndSortingByNameFurniture(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "nameFurniture");
        return furnitureRepository.findAllFurnitureBy(pageable);
    }
}