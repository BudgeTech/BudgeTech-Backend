package br.sc.senac.budgetech.backend.service.client;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.exception.address.AddressNotFoundException;
import br.sc.senac.budgetech.backend.exception.client.ClientCpfInvalidException;
import br.sc.senac.budgetech.backend.exception.client.ClientCpfRegisteredException;
import br.sc.senac.budgetech.backend.exception.client.ClientLoginRegisteredException;
import br.sc.senac.budgetech.backend.exception.client.ClientNotFoundException;
import br.sc.senac.budgetech.backend.exception.contact.ContactNotFoundException;
import br.sc.senac.budgetech.backend.mapper.client.ClientMapper;
import br.sc.senac.budgetech.backend.model.address.Address;
import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.model.contact.Contact;
import br.sc.senac.budgetech.backend.projection.client.ClientListProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientProfileEditProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientProfileFullEditProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientProjection;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;
import br.sc.senac.budgetech.backend.repository.address.AddressRepository;
import br.sc.senac.budgetech.backend.repository.client.ClientRepository;
import br.sc.senac.budgetech.backend.repository.contact.ContactRepository;
import br.sc.senac.budgetech.backend.util.CPFValidatorFormat;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public ClientDTO save(ClientDTO clientDTO) {

        if (clientRepository.existsByCpf(clientDTO.cpf()))
            throw new ClientCpfRegisteredException("Cpf " + clientDTO.cpf() + " is already registered");

        if (clientRepository.existsByLogin(clientDTO.login()))
            throw new ClientLoginRegisteredException("Login " + clientDTO.login() + " is already registered");

        if (CPFValidatorFormat.isCPF(clientDTO.cpf()))
            throw new ClientCpfInvalidException("Cpf " + clientDTO.cpf() + " is invalid");

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

        client.setNameClient((clientDTO.nameClient() != null && !clientDTO.nameClient().isBlank()) ? clientDTO.nameClient() : client.getNameClient());
        client.setCpf((clientDTO.cpf() != null && !clientDTO.cpf().isBlank()) ? clientDTO.cpf() : client.getCpf());
        client.setLogin((clientDTO.login() != null && !clientDTO.login().isBlank()) ? clientDTO.login() : client.getLogin());
        client.setPassword((clientDTO.password() != null && !clientDTO.password().isBlank()) ? clientDTO.password() : client.getPassword());
        client.setLastName((clientDTO.lastName() != null && !clientDTO.lastName().isBlank()) ? clientDTO.lastName() : client.getLastName());
        client.setImage(clientDTO.image());

        Optional<ClientProjection> existsCpf = clientRepository.findClientByCpf(clientDTO.cpf());
        Optional<ClientProjection> existsLogin = clientRepository.findClientByLogin(clientDTO.login());

        if (existsCpf.isPresent() && (existsCpf.get().getId().equals(id)))
            throw new ClientCpfRegisteredException("Cpf " + clientDTO.cpf() + " is already registered");

        if (existsLogin.isPresent() && (existsLogin.get().getId().equals(id)))
            throw new ClientLoginRegisteredException("Login " + clientDTO.login() + " is already registered");

        if (clientDTO.cpf() != null && CPFValidatorFormat.isCPF(clientDTO.cpf()))
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

    public ClientProjection findByCpf(String cpf) {
        return clientRepository.findClientByCpf(cpf)
                .orElseThrow(() -> new ClientNotFoundException("Client " + cpf + " was not found"));
    }

    public ClientProjection findByNameClient(String nameClient) {
        return clientRepository.findClientByNameClient(nameClient)
                .orElseThrow(() -> new ClientNotFoundException("Client " + nameClient + " was not found"));
    }

    public ClientProfileEditProjection findProfileEditById(Long id) {
        return clientRepository.findClientProfileEditById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }

    public ClientProjection findByContactPhoneNumber(String phoneNumber) {
        return clientRepository.findClientByContactPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ClientNotFoundException("Client " + phoneNumber + " was not found"));
    }

    public ClientProfileFullEditProjection findProfileFullEditById(Long id) {
        return clientRepository.findClientProfileFullEditById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }
    public Page<ClientListProjection> findWithPaginationAndSortingByClientId(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "client_name");
        return clientRepository.findAllClientBy(pageable);
    }
}