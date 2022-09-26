package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.furniture.FurnitureDTO;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureInvalidException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNameRegisteredException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.budgetech.backend.exception.livingarea.LivingAreaNotFoundException;
import br.sc.senac.budgetech.backend.mapper.furniture.FurnitureMapper;
import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureWithColorProjectionC14andW15andW18;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjectionC15andW17;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;
import br.sc.senac.budgetech.backend.repository.furniture.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.livingArea.LivingAreaRepository;
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

        furniture.setDescription(furnitureDTO.description());
        furniture.setNameFurniture(furnitureDTO.nameFurniture());
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

    public List<FurnitureProjection> findByNameFurniture(String nameFurniture) {
        List<FurnitureProjection> furniture = furnitureRepository.findFurnitureByNameFurniture(nameFurniture);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Name " + nameFurniture + " was not found");
        return furniture;
    }

    public List<FurnitureProjection> findByPriceFurniture(Double priceFurniture) {
        List<FurnitureProjection> furniture = furnitureRepository.findFurnitureByPriceFurniture(priceFurniture);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Price " + priceFurniture + " was not found");
        return furniture;
    }

    public List<FurnitureProjection> findListByPriceFurniture(Double priceFurniture) {
        List<FurnitureProjection> furniture = furnitureRepository.findFurnitureListByPriceFurniture(priceFurniture);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Furniture " + priceFurniture + " was not found");
        return furniture;
    }

    public List<FurnitureListProjectionC15andW17> findListById(Long id) {
        List<FurnitureListProjectionC15andW17> furniture = furnitureRepository.findFurnitureListById(id);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Furniture " + id + " was not found");
        return furniture;
    }

    public Page<FurnitureListProjectionC15andW17> findWithPaginationAndSorting(int offset, int pageSize, String field) {
        return furnitureRepository.findAllFurnitureBy(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    }

    public Page<FurnitureListProjectionC15andW17> findWithPaginationAndSortingByPriceFurniture(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "priceFurniture");
        return furnitureRepository.findAllFurnitureBy(pageable);
    }

    public Page<FurnitureListProjectionC15andW17> findWithPaginationAndSortingByNameFurniture(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "nameFurniture");
        return furnitureRepository.findAllFurnitureBy(pageable);
    }

    public Page<FurnitureListProjectionC15andW17> findWithPaginationAndSortingByNameFurnitureW17(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 5, Sort.Direction.ASC, "nameFurniture");
        return furnitureRepository.findAllFurnitureW17By(pageable);
    }

    public FurnitureWithColorProjectionC14andW15andW18 findFurnitureById(Long id) {
        return furnitureRepository.findFurnitureProjectionById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Id " + id + " was not found"));
    }
}