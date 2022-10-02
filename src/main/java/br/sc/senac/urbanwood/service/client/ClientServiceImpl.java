package br.sc.senac.urbanwood.service.client;

import br.sc.senac.urbanwood.dto.client.ClientDTOC13;
import br.sc.senac.urbanwood.dto.client.ClientDTO;
import br.sc.senac.urbanwood.exception.address.AddressNotFoundException;
import br.sc.senac.urbanwood.exception.client.ClientCpfInvalidException;
import br.sc.senac.urbanwood.exception.client.ClientCpfRegisteredException;
import br.sc.senac.urbanwood.exception.client.ClientLoginRegisteredException;
import br.sc.senac.urbanwood.exception.client.ClientNotFoundException;
import br.sc.senac.urbanwood.exception.contact.ContactNotFoundException;
import br.sc.senac.urbanwood.mapper.client.ClientMapper;
import br.sc.senac.urbanwood.model.address.Address;
import br.sc.senac.urbanwood.model.client.Client;
import br.sc.senac.urbanwood.model.contact.Contact;
import br.sc.senac.urbanwood.model.image.ImageModel;
import br.sc.senac.urbanwood.projection.client.ClientProjection;
import br.sc.senac.urbanwood.projection.client.screen.*;
import br.sc.senac.urbanwood.repository.address.AddressRepository;
import br.sc.senac.urbanwood.repository.client.ClientRepository;
import br.sc.senac.urbanwood.repository.contact.ContactRepository;
import br.sc.senac.urbanwood.repository.image.ImageRepository;
import br.sc.senac.urbanwood.util.CPFValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;
    private final ImageRepository imageRepository;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper, ContactRepository contactRepository, AddressRepository addressRepository, ImageRepository imageRepository) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
        this.imageRepository = imageRepository;
    }

    public ClientDTO save(ClientDTO clientDTO) {

        Contact contact = contactRepository.findById(clientDTO.idContact())
                .orElseThrow(() -> new ContactNotFoundException("Contact " + clientDTO.idContact() + " was not found"));

        Address address = addressRepository.findById(clientDTO.idAddress())
                .orElseThrow(() -> new AddressNotFoundException("Address " + clientDTO.idAddress() + " was not found"));

        ImageModel imageModel = imageRepository.findById(clientDTO.idImage())
                .orElseThrow(() -> new AddressNotFoundException("Image " + clientDTO.idImage() + " was not found"));

        if (clientRepository.existsByCpf(clientDTO.cpf()))
            throw new ClientCpfRegisteredException("Cpf " + clientDTO.cpf() + " is already registered");

        if (clientRepository.existsByLogin(clientDTO.login()))
            throw new ClientLoginRegisteredException("Login " + clientDTO.login() + " is already registered");

        if (CPFValidator.isCPF(clientDTO.cpf()))
            throw new ClientCpfInvalidException("Cpf " + clientDTO.cpf() + " is invalid");

        Client client = clientMapper.toEntity(clientDTO);
        client.setContact(contact);
        client.setAddress(address);
        client.setImageModel(imageModel);
        Client clientSaved = clientRepository.save(client);
        return clientMapper.toDTO(clientSaved);
    }

    public void update(ClientDTO clientDTO, Long id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));

        if (CPFValidator.isCPF(clientDTO.cpf()))
            throw new ClientCpfInvalidException("Cpf " + clientDTO.cpf() + " is invalid");

        if (clientDTO.cpf().equals(client.getCpf()) && clientDTO.login().equals(client.getLogin())) {
            client.setCpf(clientDTO.cpf());
            client.setLogin(clientDTO.login());
            client.setPassword(clientDTO.password());
            client.setLastName(clientDTO.lastName());
            client.setNameClient(clientDTO.nameClient());
            clientRepository.save(client);
            return;
        }

        if (clientRepository.existsByCpf(clientDTO.cpf()))
            throw new ClientCpfRegisteredException("Cpf " + clientDTO.cpf() + " is already registered");

        if (clientRepository.existsByLogin(clientDTO.login()))
            throw new ClientLoginRegisteredException("Login " + clientDTO.login() + " is already registered");

        client.setCpf(clientDTO.cpf());
        client.setLogin(clientDTO.login());
        client.setPassword(clientDTO.password());
        client.setLastName(clientDTO.lastName());
        client.setNameClient(clientDTO.nameClient());
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

        if (client.isEmpty())
            throw new ClientNotFoundException("Client " + nameClient + " was not found");
        return client;
    }

    //Screen

    public Page<ClientProjectionW9> findW9ByNameClient(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "nameClient");
        return clientRepository.findClientW9ByNameClient(pageable);
    }

    public ClientProjectionW10 findW10ById(Long id) {
        return clientRepository.findClientW10ById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }

    public ClientDTOC13 findC13ById(Long id) {
        var testClass = new ClientDTOC13(clientRepository.findClientC13ById(id).orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found")));
        testClass.setFurnitures(clientRepository.findClientC13ByIdPart2(id));
        return testClass;
    }

    public ClientProjectionC6 findC6ById(Long id) {
        return clientRepository.findClientC6ById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }

    public ClientProjectionC7 findC7ById(Long id) {
        return clientRepository.findClientC7ById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
    }
}