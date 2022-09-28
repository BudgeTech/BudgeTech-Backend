package br.sc.senac.budgetech.backend.projection.order;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.model.item.Item;
import br.sc.senac.budgetech.backend.projection.furniture.FurnitureProjection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderC13andW13 {

    //Order
    private Double priceOrder;
    private Payment payment;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Long id;

    //Client
    private String nameClient;
    private String cpf;

    //Contact
    private String email;
    private String phoneNumber;

    //Address
    private String street;
    private String neighborhood;
    private String cep;
    private Integer number;
    private String city;

    //Furniture
    private List<FurnitureProjection> furnitureProjections = new ArrayList<>();

    public OrderC13andW13(OrderWithFurnitureProjectionC13andW13 order) {
        priceOrder = order.getPriceOrder();
        payment = order.getPayment();
        initialDate = order.getInitialDate();
        finalDate = order.getFinalDate();
        id = order.getId();
        nameClient = order.getNameClient();
        cpf = order.getCpf();
        email = order.getEmail();
        phoneNumber = order.getPhoneNumber();
        street = order.getStreet();
        neighborhood = order.getNeighborhood();
        cep = order.getCep();
        number = order.getNumber();
        city = order.getCity();
    }

    public void addFurniture(FurnitureProjection furnitureProjections) {
        this.furnitureProjections.add(furnitureProjections);
    }

    public void removeFurniture(FurnitureProjection furnitureProjections) {
        this.furnitureProjections.remove(furnitureProjections);
    }

    public Double getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(Double priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<FurnitureProjection> getFurnitureProjections() {
        return furnitureProjections;
    }

    public void setFurnitureProjections(List<FurnitureProjection> furnitureProjections) {
        this.furnitureProjections = furnitureProjections;
    }
}
