package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @Column(name = "quantity_item", length = 35, nullable = false)
    private int quantity;

    @Column(name = "total_price_item", length = 250, nullable = false)
    private double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_request")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_woodwork")
    private Woodwork woodwork;

    public Item(Long id, int quantity, double totalPrice) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}