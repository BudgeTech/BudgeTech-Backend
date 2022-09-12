package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureListDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureTelaDTO;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureInvalidException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNameRegisteredException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.budgetech.backend.exception.livingarea.LivingAreaNotFoundException;
import br.sc.senac.budgetech.backend.mapper.FurnitureMapper;
import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.model.LivingArea;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.backend.repository.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.LivingAreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public FurnitureTelaDTO findByIdDTO(Long id) {
        FurnitureProjection furniture = furnitureRepository.findFurnitureById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Furniture " + id + " was not found"));
        return furnitureMapper.toDTO(furniture);
    }

    public FurnitureListDTO findFurnitureListById(Long id) {
        List<FurnitureListProjection> furniture = furnitureRepository.findFurnitureListById(id);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Furniture " + id + " was not found");
        return furnitureMapper.toDTO(furniture);
    }

//    public Page<FurnitureListProjection> findFurnitureOrderByAscName(Pageable pageable, Integer page) {
//        pageable = PageRequest.of(page, 3, Sort.by("name").ascending());
//       return furnitureRepository.findFurniture(pageable);
//    }

    public Page<FurnitureListProjection> findFurnitureOrderByAscName(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC,("name"));
        return furnitureRepository.findFurniture(pageable);
    }
}