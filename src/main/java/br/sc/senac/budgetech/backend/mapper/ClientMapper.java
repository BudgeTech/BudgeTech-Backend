package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.ClientDTO;
import br.sc.senac.budgetech.backend.model.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        return new ClientDTO(client.getLogin(), client.getPassword(), client.getImage(), client.getId(), client.getName(), client.getLastName(), client.getCpf(), client.getContact().getId(), client.getAddress().getId());
    }

    public Client toEntity(ClientDTO dto) {
        return new Client(dto.login(), dto.password(), dto.image(), dto.id(), dto.name(), dto.lastName(), dto.cpf());
    }
}
