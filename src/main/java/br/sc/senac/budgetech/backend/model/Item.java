package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToOne
    @JoinColumn(name = "id_request")
    private Request request;

    @OneToMany(mappedBy = "item")
    private List<Furniture> furnitures;

    public Item(Long id, int quantity, double totalPrice) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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
}