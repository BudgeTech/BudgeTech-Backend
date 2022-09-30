package br.sc.senac.urbanwood.model.item;

import br.sc.senac.urbanwood.model.client.Client;
import br.sc.senac.urbanwood.model.order.Order;
import br.sc.senac.urbanwood.model.woodwork.Woodwork;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_quantity", length = 35, nullable = false)
    private Integer quantity;

    @Column(name = "item_total_price", length = 250, nullable = false)
    private Double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderClass_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "woodwork_id")
    private Woodwork woodwork;

    public Item() {
    }

    public Item(Long id, Integer quantity, Double totalPrice) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Woodwork getWoodwork() {
        return woodwork;
    }

    public void setWoodwork(Woodwork woodwork) {
        this.woodwork = woodwork;
    }
}