package br.sc.senac.urbanwood.backend.mapper;

import br.sc.senac.urbanwood.backend.dto.client.ClientDTO;
import br.sc.senac.urbanwood.backend.dto.client.ClientProfileEditDTO;
import br.sc.senac.urbanwood.backend.dto.client.ClientProfileFullEditDTO;
import br.sc.senac.urbanwood.backend.model.Client;
import br.sc.senac.urbanwood.backend.projection.client.ClientProfileEditProjection;
import br.sc.senac.urbanwood.backend.projection.client.ClientProfileFullEditProjection;

import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        return new ClientDTO(client.getLogin(), client.getPassword(), client.getImage(), client.getId(), client.getNameClient(), client.getLastName(), client.getCpf(), client.getContact().getId(), client.getAddress().getId());
    }

    public Client toEntity(ClientDTO dto) {
        return new Client(dto.login(), dto.password(), dto.image(), dto.id(), dto.nameClient(), dto.lastName(), dto.cpf());
    }

    public ClientProfileEditDTO toDTO(ClientProfileEditProjection client) {
        return new ClientProfileEditDTO(client.getNameClient(), client.getLastName(), client.getCpf());
    }

    public ClientProfileFullEditDTO toDTO(ClientProfileFullEditProjection client) {
        return new ClientProfileFullEditDTO(client.getNameClient(), client.getLastName(), client.getCpf(), client.getImage(), client.getAddress().getStreet(), client.getAddress().getNumber(), client.getAddress().getComplement(), client.getAddress().getNeighbor(), client.getAddress().getCity(), client.getAddress().getCep(), client.getContact().getPhoneNumber(), client.getContact().getEmail(), client.getContact().getSocialNetwork());
    }
}
