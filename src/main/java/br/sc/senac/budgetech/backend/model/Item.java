package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_quantity", length = 35, nullable = false)
    private int quantity;

    @Column(name = "item_total_price", length = 250, nullable = false)
    private Double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "woodwork_id")
    private Woodwork woodwork;

    public Item(Long id, int quantity, Double totalPrice) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}