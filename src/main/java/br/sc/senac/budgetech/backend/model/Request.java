package br.sc.senac.budgetech.backend.model;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private Long id;

    @Column(name = "price_request")
    private double price;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_request", nullable = false)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "payment_request", nullable = false)
    private Payment payment;

    @Column(name = "initial_date_request", nullable = false)
    private LocalDate initialDate;

    @Column(name = "final_date_request")
    private LocalDate finalDate;

    @OneToOne(mappedBy = "request")
    private Item item;

    @ManyToMany
    @JoinTable(name = "request_furniture", joinColumns = @JoinColumn(name = "id_request"), inverseJoinColumns = @JoinColumn(name = "id_furniture"))
    private List<Furniture> furnitures;

    public Request() {
        furnitures = new ArrayList<>();
    }

    public Request(Long id, double price, Status status, Payment payment, LocalDate initialDate, LocalDate finalDate) {
        this.id = id;
        this.price = price;
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

    public List<Furniture> getFurniture() {
        return furnitures;
    }

    public double calculationPrice() {

        double valor = 0;

        for (Furniture furniture : furnitures) {
            valor += furniture.getPrice();
        }

        return valor;
    }
}

