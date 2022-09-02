package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "item")
    private List<Furniture> furnitures;

    @OneToOne
    @JoinColumn(name = "id_request")
    private Request request;

}