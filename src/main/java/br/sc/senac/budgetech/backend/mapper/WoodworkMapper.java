package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.WoodworkDTO;
import br.sc.senac.budgetech.backend.model.Woodwork;
import org.springframework.stereotype.Service;

@Service
public class WoodworkMapper {

    public WoodworkDTO toDTO(Woodwork woodwork) {
        return new WoodworkDTO(woodwork.getLogin(), woodwork.getPassword(), woodwork.getImage(), woodwork.getId(), woodwork.getCompanyName(), woodwork.getCnpj(), woodwork.getDescription(), woodwork.getContact().getId(), woodwork.getAddress().getId());
    }

    public Woodwork toEntity(WoodworkDTO dto) {
        return new Woodwork(dto.login(), dto.password(), dto.image(), dto.id(), dto.companyName(), dto.cnpj(), dto.description());
    }
}
