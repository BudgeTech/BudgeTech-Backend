package br.sc.senac.urbanwood.mapper.client;


import br.sc.senac.urbanwood.dto.client.ClientDTO;
import br.sc.senac.urbanwood.model.client.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        return new ClientDTO(client.getLogin(), client.getPassword(), client.getImage(), client.getId(), client.getNameClient(), client.getLastName(), client.getCpf(), client.getContact().getId(), client.getAddress().getId());
    }

    public Client toEntity(ClientDTO dto) {
        return new Client(dto.id(), dto.login(), dto.password(), dto.image(), dto.nameClient(), dto.lastName(), dto.cpf());
    }
}
