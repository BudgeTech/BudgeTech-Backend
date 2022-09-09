package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.WoodworkProfileDTO;
import br.sc.senac.budgetech.backend.dto.WoodworkDTO;
import br.sc.senac.budgetech.backend.model.Woodwork;
import br.sc.senac.budgetech.backend.projection.WoodworkProfileProjection;
import br.sc.senac.budgetech.backend.projection.WoodworkProjection;
import org.springframework.stereotype.Service;

@Service
public class WoodworkMapper {

    public WoodworkDTO toDTO(Woodwork woodwork) {
        return new WoodworkDTO(woodwork.getLogin(), woodwork.getPassword(), woodwork.getImage(), woodwork.getId(), woodwork.getCompanyName(), woodwork.getCnpj(), woodwork.getDescription(), woodwork.getContact().getId(), woodwork.getAddress().getId());
    }

    public Woodwork toEntity(WoodworkDTO dto) {
        return new Woodwork(dto.login(), dto.password(), dto.image(), dto.id(), dto.companyName(), dto.cnpj(), dto.description());
    }

    public WoodworkProfileDTO toDTO(WoodworkProfileProjection woodwork) {
        return new WoodworkProfileDTO(woodwork.getCompanyName(), woodwork.getDescription(), woodwork.getAddress().getProvince(), woodwork.getAddress().getNeighbor(), woodwork.getContact().getPhoneNumber(), woodwork.getCnpj(), woodwork.getContact().getEmail(), woodwork.getContact().getSocialNetwork());
    }
}
