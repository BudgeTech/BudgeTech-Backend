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
import br.sc.senac.budgetech.backend.projection.client.ClientListProjectionW9;
import br.sc.senac.budgetech.backend.projection.client.ClientListW10;
import br.sc.senac.budgetech.backend.projection.client.ClientProjection;
import br.sc.senac.budgetech.backend.repository.address.AddressRepository;
import br.sc.senac.budgetech.backend.repository.client.ClientRepository;
import br.sc.senac.budgetech.backend.repository.contact.ContactRepository;
import br.sc.senac.budgetech.backend.repository.item.ItemRepository;
import br.sc.senac.budgetech.backend.util.CPFValidator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ItemRepository itemRepository;
    private final ClientMapper clientMapper;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public ClientDTO save(ClientDTO clientDTO) {

        if (clientRepository.existsByCpf(clientDTO.cpf()))
            throw new ClientCpfRegisteredException("Cpf " + clientDTO.cpf() + " is already registered");

        if (clientRepository.existsByLogin(clientDTO.login()))
            throw new ClientLoginRegisteredException("Login " + clientDTO.login() + " is already registered");

        if (CPFValidator.isCPF(clientDTO.cpf()))
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

        client.setCpf(clientDTO.cpf());
        client.setLogin(clientDTO.login());
        client.setImage(clientDTO.image());
        client.setPassword(clientDTO.password());
        client.setLastName(clientDTO.lastName());
        client.setNameClient(clientDTO.nameClient());

        Optional<ClientProjection> existsCpf = clientRepository.findClientByCpf(clientDTO.cpf());
        Optional<ClientProjection> existsLogin = clientRepository.findClientByLogin(clientDTO.login());

        if (existsCpf.isPresent() && (existsCpf.get().getId().equals(id)))
            throw new ClientCpfRegisteredException("Cpf " + clientDTO.cpf() + " is already registered");

        if (existsLogin.isPresent() && (existsLogin.get().getId().equals(id)))
            throw new ClientLoginRegisteredException("Login " + clientDTO.login() + " is already registered");

        if (clientDTO.cpf() != null && CPFValidator.isCPF(clientDTO.cpf()))
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

    public List<ClientProjection> findByNameClient(String nameClient) {
        List<ClientProjection> client = clientRepository.findClientByNameClient(nameClient);
        if(client.isEmpty())
            throw new ClientNotFoundException("Client " + nameClient + " was not found");
        return client;
    }

    public ClientProjection findByContactPhoneNumber(String phoneNumber) {
        return clientRepository.findClientByContactPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ClientNotFoundException("Client " + phoneNumber + " was not found"));
    }

    public ClientListW10 findProfileFullEditBy(Long id) {
        var client = new ClientListW10(clientRepository.findClientW10(id));
        client.setOrderProjections(itemRepository.findIdOrderByIdClient(client.getId()));
        return client;
    }

    public Page<ClientListProjectionW9> findWithPaginationAndSortingByClientId(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "client_name");
        return clientRepository.findAllClientBy(pageable);
    }
}