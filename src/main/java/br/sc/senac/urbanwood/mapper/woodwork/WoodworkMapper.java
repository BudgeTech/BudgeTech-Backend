package br.sc.senac.urbanwood.mapper.woodwork;

import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.model.woodwork.Woodwork;
import org.springframework.stereotype.Service;

@Service
public class WoodworkMapper {

    public WoodworkDTO toDTO(Woodwork woodwork) {
        return new WoodworkDTO(woodwork.getLogin(), woodwork.getPassword(), woodwork.getId(), woodwork.getCompanyName(), woodwork.getCnpj(), woodwork.getDescription(), woodwork.getContact().getId(), woodwork.getAddress().getId(), woodwork.getImageModel().getId());
    }

    public Woodwork toEntity(WoodworkDTO dto) {
        return new Woodwork(dto.idUser(), dto.login(), dto.password(), dto.companyName(), dto.cnpj(), dto.description());
    }
}
