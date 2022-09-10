package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.dto.client.ClientProfileEditDTO;
import br.sc.senac.budgetech.backend.dto.client.ClientProfileFullEditDTO;
import br.sc.senac.budgetech.backend.exception.address.AddressNotFoundException;
import br.sc.senac.budgetech.backend.exception.client.ClientCpfInvalidException;
import br.sc.senac.budgetech.backend.exception.client.ClientCpfRegisteredException;
import br.sc.senac.budgetech.backend.exception.client.ClientLoginRegisteredException;
import br.sc.senac.budgetech.backend.exception.client.ClientNotFoundException;
import br.sc.senac.budgetech.backend.exception.contact.ContactNotFoundException;
import br.sc.senac.budgetech.backend.mapper.ClientMapper;
import br.sc.senac.budgetech.backend.model.Address;
import br.sc.senac.budgetech.backend.model.Client;
import br.sc.senac.budgetech.backend.model.Contact;
import br.sc.senac.budgetech.backend.projection.client.*;
import br.sc.senac.budgetech.backend.repository.AddressRepository;
import br.sc.senac.budgetech.backend.repository.ClientRepository;
import br.sc.senac.budgetech.backend.repository.ContactRepository;
import br.sc.senac.budgetech.backend.utils.ValidateCPF;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public ClientDTO save(ClientDTO clientDTO) {

        if (ValidateCPF.isCPF(clientDTO.cpf()))
            throw new ClientCpfInvalidException("Cpf " + clientDTO.cpf() + " is invalid");

        if (clientRepository.existsByCpf(clientDTO.cpf()))
            throw new ClientCpfRegisteredException("Cpf " + clientDTO.cpf() + " is already registered");

        if (clientRepository.existsByLogin(clientDTO.login()))
            throw new ClientLoginRegisteredException("Login " + clientDTO.login() + " is already registered");

        Contact contact = contactRepository.findById(clientDTO.idContact())
                .orElseThrow(() -> new ContactNotFoundException("Contact " + clientDTO.idContact() + " was not found"));

        Address address = addressRepository.findById(clientDTO.idAddress())
                .orElseThrow(() -> new AddressNotFoundException("Address " + clientDTO.idAddress() + " was not found"));

        Client client = clientMapper.toEntity(clientDTO);
        client.setContact(contact);
        client.setAddress(address);
        Client clientSaved = clientRepository.save(client);
        return clientMapper.toDTO(clientSaved);
    }

    public void update(ClientDTO clientDTO, Long id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));

        Contact contact = contactRepository.findById(clientDTO.idContact())
                .orElseThrow(() -> new ContactNotFoundException("Contact " + clientDTO.idContact() + " was not found"));

        Address address = addressRepository.findById(clientDTO.idAddress())
                .orElseThrow(() -> new AddressNotFoundException("Address " + clientDTO.idAddress() + " was not found"));

        client.setNameClient((clientDTO.nameClient() != null && !clientDTO.nameClient().isBlank()) ? clientDTO.nameClient() : client.getNameClient());
        client.setCpf((clientDTO.cpf() != null && !clientDTO.cpf().isBlank()) ? clientDTO.cpf() : client.getCpf());
        client.setLogin((clientDTO.login() != null && !clientDTO.login().isBlank()) ? clientDTO.login() : client.getLogin());
        client.setPassword((clientDTO.password() != null && !clientDTO.password().isBlank()) ? clientDTO.password() : client.getPassword());
        client.setLastName((clientDTO.lastName() != null && !clientDTO.lastName().isBlank()) ? clientDTO.lastName() : client.getLastName());
        client.setImage(clientDTO.image());
        client.setContact(contact);
        client.setAddress(address);

        var existsCpf = clientRepository.findClientByCpf(clientDTO.cpf());
        var existsLogin = clientRepository.findClientByLogin(clientDTO.login());

        if (existsCpf.isPresent() && (existsCpf.get().getId().equals(id)))
            throw new ClientCpfRegisteredException("Cpf " + clientDTO.cpf() + " is already registered");

        if (existsLogin.isPresent() && (existsLogin.get().getId().equals(id)))
            throw new ClientLoginRegisteredException("Login " + clientDTO.login() + " is already registered");

        if (ValidateCPF.isCPF(client.getCpf()))
            throw new ClientCpfInvalidException("Cpf " + clientDTO.cpf() + " is invalid");

        clientRepository.save(client);
    }

    public void delete(Long id) {
        if (!clientRepository.existsById(id)) throw new ClientNotFoundException("Client " + id + " was not found");
        clientRepository.deleteById(id);
    }

    public ClientProjection findById(Long id) {
        return clientRepository.findClientById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }

    public ClientProjection findByNameClient(String nameClient) {
        return clientRepository.findClientByNameClient(nameClient)
                .orElseThrow(() -> new ClientNotFoundException("Client " + nameClient + " was not found"));
    }

    public ClientProjection findByCpf(String cpf) {
        return clientRepository.findClientByCpf(cpf)
                .orElseThrow(() -> new ClientNotFoundException("Client " + cpf + " was not found"));
    }

    public ClientProjection findByContactPhoneNumber(String phoneNumber) {
        return clientRepository.findClientByContactPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ClientNotFoundException("Client " + phoneNumber + " was not found"));
    }

    public ClientWithAddressAndContactProjection findWithAddressAndContactById(Long id) {
        return clientRepository.findClientWithAddressAndContactById(id).orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }

    public ClientWithItemProjection findWithItemById(Long id) {
        return clientRepository.findClientWithItemById(id).orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }

    public ClientWithAllProjection findWithAddressAndContactAndItemById(Long id) {
        return clientRepository.findClientWithAddressAndContactAndItemById(id).orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }

    public ClientProfileEditDTO findProfileEditById(Long id) {
        ClientProfileEditProjection woodwork = clientRepository.findClientProfileEditById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
        return clientMapper.toDTO(woodwork);
    }

    public ClientProfileFullEditDTO findProfileFullEditById(Long id) {
        ClientProfileFullEditProjection client = clientRepository.findClientProfileFullEditById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
        return clientMapper.toDTO(client);
    }
}