package br.sc.senac.urbanwood.model.address;

import br.sc.senac.urbanwood.model.client.Client;
import br.sc.senac.urbanwood.model.woodwork.Woodwork;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address_street", length = 45, nullable = false)
    private String street;

    @Column(name = "address_number", nullable = false)
    private Integer number;

    @Column(name = "address_complement", length = 45, nullable = false)
    private String complement;

    @Column(name = "address_neighborhood", length = 45, nullable = false)
    private String neighborhood;

    @Column(name = "address_city", length = 45, nullable = false)
    private String city;

    @Column(name = "address_province", length = 45, nullable = false)
    private String province;

    @Column(name = "address_cep", nullable = false)
    private String cep;

    @OneToOne(mappedBy = "address")
    private Woodwork woodwork;

    @OneToOne(mappedBy = "address")
    private Client client;

    public Address() {}

    public Address(Long id, String street, Integer number, String complement, String neighborhood, String city, String province, String cep) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.province = province;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Woodwork getWoodwork() {
        return woodwork;
    }

    public void setWoodwork(Woodwork woodwork) {
        this.woodwork = woodwork;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

