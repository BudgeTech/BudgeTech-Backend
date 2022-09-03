package br.sc.senac.budgetech.backend.service.furniture;

import br.sc.senac.budgetech.backend.dto.FurnitureDTO;
import br.sc.senac.budgetech.backend.exception.address.AddressNotFoundException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureInvalidException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNameRegisteredException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.budgetech.backend.exception.livingarea.LivingAreaNotFoundException;
import br.sc.senac.budgetech.backend.mapper.FurnitureMapper;
import br.sc.senac.budgetech.backend.model.Furniture;
import br.sc.senac.budgetech.backend.model.LivingArea;
import br.sc.senac.budgetech.backend.projection.FurnitureProjection;
import br.sc.senac.budgetech.backend.repository.FurnitureRepository;
import br.sc.senac.budgetech.backend.repository.LivingAreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;
    private final LivingAreaRepository livingAreaRepository;

    public FurnitureDTO save(FurnitureDTO furnitureDTO) {

        if (furnitureRepository.existsByName(furnitureDTO.name()))
            throw new FurnitureNameRegisteredException("Furniture " + furnitureDTO.name() + " is already registered");

        LivingArea livingArea = livingAreaRepository.findById(furnitureDTO.idLivingArea())
                .orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + furnitureDTO.idLivingArea() + " was not found"));

        if (furnitureDTO.furnitureSize() <= 0)
            throw new FurnitureInvalidException("Furniture Size " + furnitureDTO.furnitureSize() + " is invalid");

        if (furnitureDTO.price() < 0)
            throw new FurnitureInvalidException("Price " + furnitureDTO.price() + " is invalid");

        Furniture furniture = furnitureMapper.toEntity(furnitureDTO);
        furniture.setLivingArea(livingArea);
        Furniture furnitureSaved = furnitureRepository.save(furniture);

        return furnitureMapper.toDTO(furnitureSaved);
    }

    public void update(FurnitureDTO furnitureDTO, Long id) {
        Furniture furniture = furnitureRepository.findById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Furniture " + id + " was not found"));

        if (furnitureRepository.existsByName(furnitureDTO.name()))
            throw new FurnitureNameRegisteredException("Name " + furnitureDTO.name() + " is already registered");

        if (furnitureDTO.furnitureSize() <= 0)
            throw new FurnitureInvalidException("Furniture Size " + furnitureDTO.furnitureSize() + " is invalid");

        if (furnitureDTO.price() < 0)
            throw new FurnitureInvalidException("Price " + furnitureDTO.price() + " is invalid");

        furniture.setName((furnitureDTO.name() != null && furnitureDTO.name().isBlank()) ? furnitureDTO.name() : furniture.getName());
        furniture.setDescription((furnitureDTO.description() != null && furnitureDTO.description().isBlank()) ? furnitureDTO.description() : furniture.getDescription());
        furniture.setFurnitureSize(furnitureDTO.furnitureSize());
        furniture.setPrice(furnitureDTO.price());
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

    public FurnitureProjection findByName(String name) {
        return furnitureRepository.findFurnitureByName(name)
                .orElseThrow(() -> new FurnitureNotFoundException("Name " + name + " was not found"));
    }

    public FurnitureProjection findByPrice(double price) {
        return furnitureRepository.findFurnitureByPrice(price)
                .orElseThrow(() -> new FurnitureNotFoundException("Price " + price + " was not found"));
    }
}