package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.dto.client.ClientProfileEditDTO;
import br.sc.senac.budgetech.backend.model.Client;
import br.sc.senac.budgetech.backend.projection.client.ClientProfileEditProjection;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        return new ClientDTO(client.getLogin(), client.getPassword(), client.getImage(), client.getId(), client.getName(), client.getLastName(), client.getCpf(), client.getContact().getId(), client.getAddress().getId());
    }

    public Client toEntity(ClientDTO dto) {
        return new Client(dto.login(), dto.password(), dto.image(), dto.id(), dto.name(), dto.lastName(), dto.cpf());
    }

    public ClientProfileEditDTO toDTO(ClientProfileEditProjection client) {
        return new ClientProfileEditDTO(client.getName(), client.getLastName(), client.getCpf());
    }
}
