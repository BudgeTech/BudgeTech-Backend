package br.sc.senac.budgetech.backend.mapper.client;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.projection.client.ClientProfileEditProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientProfileFullEditProjection;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        return new ClientDTO(client.getLogin(), client.getPassword(), client.getImage(), client.getId(), client.getNameClient(), client.getLastName(), client.getCpf(), client.getContact().getId(), client.getAddress().getId());
    }

    public Client toEntity(ClientDTO dto) {
        return new Client(dto.login(), dto.password(), dto.image(), dto.id(), dto.nameClient(), dto.lastName(), dto.cpf());
    }
}
