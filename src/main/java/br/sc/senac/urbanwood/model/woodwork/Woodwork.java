package br.sc.senac.urbanwood.model.woodwork;

import br.sc.senac.urbanwood.model.address.Address;
import br.sc.senac.urbanwood.model.contact.Contact;
import br.sc.senac.urbanwood.model.item.Item;
import br.sc.senac.urbanwood.model.living_area.LivingArea;
import br.sc.senac.urbanwood.model.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "woodwork")
@PrimaryKeyJoinColumn(name = "woodwork_id", referencedColumnName = "user_id")
public class Woodwork extends User {

    @Column(name = "woodwork_company_name", nullable = false)
    private String companyName;

    @Column(name = "woodwork_cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "woodwork_description")
    private String description;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToMany(mappedBy = "woodwork", cascade = CascadeType.ALL)
    private List<LivingArea> livingAreas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Woodwork() {
        livingAreas = new ArrayList<>();
        items = new ArrayList<>();
    }

    public Woodwork(Long id, String login, String password, byte[] image, String companyName, String cnpj, String description) {
        super(id, login, password, image);
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.description = description;
        livingAreas = new ArrayList<>();
        items = new ArrayList<>();
    }

    public List<LivingArea> getLivingAreas() {
        return livingAreas;
    }

    public void setLivingAreas(List<LivingArea> livingAreas) {
        this.livingAreas = livingAreas;
    }

    public void addLivingArea(LivingArea livingArea) {
        this.livingAreas.add(livingArea);
    }

    public void removeLivingArea(LivingArea livingArea) {
        this.livingAreas.remove(livingArea);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
