package br.sc.senac.budgetech.backend.projection.client;

import java.util.ArrayList;
import java.util.List;

public class ClientListW10 {

    private Long id;

    private byte[] image;

    private String cpf;

    private String nameClient;

    private String lastName;

    //Address
    private String street;

    private Integer number;

    private String complement;

    private String neighborhood;

    private String city;

    private String cep;

    //Contact
    private String email;

    private String phoneNumber;

    private String socialNetwork;

    private List<OrderProjectionW10> orderProjections = new ArrayList<>();

    public ClientListW10(ClientW10 clientW10) {
        id = clientW10.getId();
        image = clientW10.getImage();
        cpf = clientW10.getCpf();
        nameClient = clientW10.getNameClient();
        lastName = clientW10.getLastName();
        street = clientW10.getStreet();
        number = clientW10.getNumber();
        complement = clientW10.getLastName();
        neighborhood = clientW10.getNeighborhood();
        city = clientW10.getCity();
        cep = clientW10.getCep();
        email = clientW10.getEmail();
        phoneNumber = clientW10.getPhoneNumber();
        socialNetwork = clientW10.getSocialNetwork();
    }

    public List<OrderProjectionW10> getOrderProjections() {
        return orderProjections;
    }

    public void setOrderProjections(List<OrderProjectionW10> orderProjections) {
        this.orderProjections = orderProjections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
}
