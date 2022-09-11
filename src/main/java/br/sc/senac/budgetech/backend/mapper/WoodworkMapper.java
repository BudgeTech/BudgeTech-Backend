package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.woodwork.*;
import br.sc.senac.budgetech.backend.model.Woodwork;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkProfileEditProjection;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkProfileFullEditProjection;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkProfileProjection;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkSearchProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoodworkMapper {

    public WoodworkDTO toDTO(Woodwork woodwork) {
        return new WoodworkDTO(woodwork.getLogin(), woodwork.getPassword(), woodwork.getImage(), woodwork.getId(), woodwork.getCompanyName(), woodwork.getCnpj(), woodwork.getDescription(), woodwork.getContact().getId(), woodwork.getAddress().getId());
    }

    public Woodwork toEntity(WoodworkDTO dto) {
        return new Woodwork(dto.login(), dto.password(), dto.image(), dto.id(), dto.companyName(), dto.cnpj(), dto.description());
    }

    public WoodworkProfileDTO toDTO(WoodworkProfileProjection woodwork) {
        return new WoodworkProfileDTO(woodwork.getCompanyName(), woodwork.getDescription(), woodwork.getAddress().getCity() ,woodwork.getAddress().getProvince(), woodwork.getAddress().getNeighborhood(), woodwork.getContact().getPhoneNumber(), woodwork.getCnpj(), woodwork.getContact().getEmail(), woodwork.getContact().getSocialNetwork());
    }

    public WoodworkProfileEditDTO toDTO(WoodworkProfileEditProjection woodwork) {
        return new WoodworkProfileEditDTO(woodwork.getCompanyName(), woodwork.getCnpj());
    }

    public WoodworkProfileFullEditDTO toDTO(WoodworkProfileFullEditProjection woodwork) {
        return new WoodworkProfileFullEditDTO(woodwork.getCompanyName(), woodwork.getCnpj(), woodwork.getAddress().getStreet(), woodwork.getAddress().getNumber(), woodwork.getAddress().getComplement(), woodwork.getAddress().getNeighborhood(), woodwork.getAddress().getCity(), woodwork.getAddress().getCep(), woodwork.getContact().getPhoneNumber(), woodwork.getContact().getEmail(), woodwork.getContact().getSocialNetwork());
    }

    public WoodworkSearchDTO toDTO(List<WoodworkSearchProjection> woodwork) {
        return new WoodworkSearchDTO(woodwork);
    }
}
