package br.sc.senac.urbanwood.model.order;


import br.sc.senac.urbanwood.enumeration.payment.Payment;
import br.sc.senac.urbanwood.enumeration.status.Status;
import br.sc.senac.urbanwood.model.furniture.Furniture;
import br.sc.senac.urbanwood.model.item.Item;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_class")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderClass_id")
    private Long id;

    @Column(name = "order_price")
    private Double priceOrder;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "order_status", nullable = false)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "order_payment", nullable = false)
    private Payment payment;

    @Column(name = "order_initial_date", nullable = false)
    private LocalDate initialDate;

    @Column(name = "order_final_date")
    private LocalDate finalDate;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Item item;

    @ManyToMany
    @JoinTable(name = "order_furniture", joinColumns = @JoinColumn(name = "orderClass_id"), inverseJoinColumns = @JoinColumn(name = "furniture_id"))
    private List<Furniture> furnitures;

    public Order() {
        furnitures = new ArrayList<>();
    }

    public Order(Long id, Double priceOrder, Status status, Payment payment, LocalDate initialDate, LocalDate finalDate) {
        this.id = id;
        this.priceOrder = priceOrder;
        this.status = status;
        this.payment = payment;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        furnitures = new ArrayList<>();
    }

    public void addFurniture(Furniture furniture) {
        this.furnitures.add(furniture);
    }

    public void removeFurniture(Furniture furniture) {
        this.furnitures.remove(furniture);
    }

    @JsonManagedReference
    public List<Furniture> getFurniture() {
        return furnitures;
    }

    public double calculationPrice() {

        double valor = 0;

        for (Furniture furniture : furnitures) {
            valor += furniture.getPriceFurniture();
        }

        return valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(Double priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }
}

