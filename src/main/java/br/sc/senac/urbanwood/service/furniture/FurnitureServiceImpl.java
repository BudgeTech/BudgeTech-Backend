package br.sc.senac.urbanwood.service.furniture;

import br.sc.senac.urbanwood.dto.furniture.FurnitureDTO;
import br.sc.senac.urbanwood.exception.furniture.FurnitureInvalidException;
import br.sc.senac.urbanwood.exception.furniture.FurnitureNameRegisteredException;
import br.sc.senac.urbanwood.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.urbanwood.exception.living_area.LivingAreaNotFoundException;
import br.sc.senac.urbanwood.mapper.furniture.FurnitureMapper;
import br.sc.senac.urbanwood.model.furniture.Furniture;
import br.sc.senac.urbanwood.model.living_area.LivingArea;
import br.sc.senac.urbanwood.projection.furniture.FurnitureProjection;
import br.sc.senac.urbanwood.projection.furniture.screen.FurnitureProjectionC14;
import br.sc.senac.urbanwood.projection.furniture.screen.FurnitureProjectionC15;
import br.sc.senac.urbanwood.repository.furniture.FurnitureRepository;
import br.sc.senac.urbanwood.repository.living_area.LivingAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;
    private final LivingAreaRepository livingAreaRepository;

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository, FurnitureMapper furnitureMapper, LivingAreaRepository livingAreaRepository) {
        this.furnitureRepository = furnitureRepository;
        this.furnitureMapper = furnitureMapper;
        this.livingAreaRepository = livingAreaRepository;
    }

    public FurnitureDTO save(FurnitureDTO furnitureDTO) {

        LivingArea livingArea = livingAreaRepository.findById(furnitureDTO.idLivingArea())
                .orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + furnitureDTO.idLivingArea() + " was not found"));

        if (furnitureRepository.existsByNameFurniture(furnitureDTO.nameFurniture()))
            throw new FurnitureNameRegisteredException("Furniture " + furnitureDTO.nameFurniture() + " is already registered");

        if (furnitureDTO.furnitureSize() <= 0 || furnitureDTO.priceFurniture() <= 0)
            throw new FurnitureInvalidException("The Furniture Size is less than zero or the Price is less than zero");

        Furniture furniture = furnitureMapper.toEntity(furnitureDTO);
        furniture.setLivingArea(livingArea);
        Furniture furnitureSaved = furnitureRepository.save(furniture);
        return furnitureMapper.toDTO(furnitureSaved);
    }

    public void update(FurnitureDTO furnitureDTO, Long id) {

        Furniture furniture = furnitureRepository.findById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Furniture " + id + " was not found"));

        if (furnitureDTO.furnitureSize() <= 0 || furnitureDTO.priceFurniture() <= 0)
            throw new FurnitureInvalidException("The Furniture Size is less than zero or the Price is less than zero");

        if (furnitureDTO.nameFurniture().equals(furniture.getNameFurniture())) {
            furniture.setDescription(furnitureDTO.description());
            furniture.setNameFurniture(furnitureDTO.nameFurniture());
            furniture.setFurnitureSize(furnitureDTO.furnitureSize());
            furniture.setPriceFurniture(furnitureDTO.priceFurniture());
            furnitureRepository.save(furniture);
            return;
        }

        if (furnitureRepository.existsByNameFurniture(furnitureDTO.nameFurniture()))
            throw new FurnitureNameRegisteredException("Furniture " + furnitureDTO.nameFurniture() + " is already registered");

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

    //Screen

    public FurnitureProjectionC14 findC14ById(Long id) {
        return furnitureRepository.findFurnitureC14ById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Id " + id + " was not found"));
    }

    public List<FurnitureProjectionC15> findC15OrderByNameFurniture() {
        List<FurnitureProjectionC15> furniture = furnitureRepository.findAllOrderByNameFurniture();

        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Was not found");
        return furniture;
    }
}