package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureListDTO;
import br.sc.senac.budgetech.backend.dto.furniture.FurnitureScreenDTO;
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
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.*;
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

    public FurnitureScreenDTO findByIdDTO(Long id) {
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

    public Page<FurnitureListProjection> findFurniture(Integer page) {
        return new PageImpl<>(furnitureRepository.findAllProjectedFurnitureBy(), PageRequest.of(page, 3, Sort.Direction.ASC,("name")), 3);
    }

    public FurnitureListDTO findFurnitureDTO(Integer page) {
        var a = new PageImpl<>(furnitureRepository.findAllProjectedFurnitureBy(), PageRequest.of(page, 3, Sort.Direction.ASC,("name")), 3);
        return furnitureMapper.toDTO(a);
    }


    public Page<Furniture> findFurnitureWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Furniture> furnitures = furnitureRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return furnitures;
    }

    //Native Query
    public Page<FurnitureListProjection> findFurnitureProjection(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "nameFurniture");
        return furnitureRepository.findAllFurnitureBy(pageable);
    }

//    public Page<FurnitureListDTO> findFurnitureDTOProjection(Pageable pageable, Integer page) {
//        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "nameFurniture");
//        return furnitureRepository.findAllFurnitureDTO(pageable);
//    }
}