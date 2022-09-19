package br.sc.senac.budgetech.backend.mapper.woodwork;

import br.sc.senac.budgetech.backend.dto.woodwork.*;
import br.sc.senac.budgetech.backend.model.woodwork.Woodwork;
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
        return new Woodwork(dto.idUser(), dto.login(), dto.password(), dto.image(), dto.companyName(), dto.cnpj(), dto.description());
    }
}
