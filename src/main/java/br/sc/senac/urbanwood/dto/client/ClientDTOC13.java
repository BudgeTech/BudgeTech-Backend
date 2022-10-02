package br.sc.senac.urbanwood.dto.client;

import br.sc.senac.urbanwood.projection.client.screen.ClientProjectionC13;
import br.sc.senac.urbanwood.projection.furniture.screen.FurnitureProjectionC13;

import java.util.ArrayList;
import java.util.List;

public class ClientDTOC13 {

    private byte[] picByte;
    private String nameClient;
    private String cpf;
    private String email;
    private String phoneNumber;
    private String street;
    private String neighborhood;
    private String cep;
    private Integer number;

    private List<FurnitureProjectionC13> furnitures;

    public ClientDTOC13() {
    }

    public ClientDTOC13(ClientProjectionC13 clientProjectionC13) {
        this.picByte = clientProjectionC13.getPicByte();
        this.nameClient = clientProjectionC13.getNameClient();
        this.cpf = clientProjectionC13.getCpf();
        this.email = clientProjectionC13.getEmail();
        this.phoneNumber = clientProjectionC13.getPhoneNumber();
        this.street = clientProjectionC13.getStreet();
        this.neighborhood = clientProjectionC13.getNeighborhood();
        this.cep = clientProjectionC13.getCep();
        this.number = clientProjectionC13.getNumber();
        furnitures = new ArrayList<>();
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<FurnitureProjectionC13> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<FurnitureProjectionC13> furnitures) {
        this.furnitures = furnitures;
    }
}
