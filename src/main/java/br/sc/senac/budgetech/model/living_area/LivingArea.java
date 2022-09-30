package br.sc.senac.budgetech.model.living_area;

import br.sc.senac.budgetech.model.furniture.Furniture;
import br.sc.senac.budgetech.model.woodwork.Woodwork;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "living_area")
public class LivingArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "living_area_id")
    private Long id;

    @Lob
    @Column(name = "living_area_image")
    private byte[] image;

    @Column(name = "living_area_name", length = 45, nullable = false)
    private String nameLivingArea;

    @ManyToOne
    @JoinColumn(name = "woodwork_id")
    private Woodwork woodwork;

    @OneToMany(mappedBy = "livingArea", cascade = CascadeType.ALL)
    private List<Furniture> furnitures;

    public LivingArea() {
        furnitures = new ArrayList<>();
    }

    public LivingArea(Long id, String nameLivingArea, byte[] image) {
        this.id = id;
        this.nameLivingArea = nameLivingArea;
        this.image = image;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getNameLivingArea() {
        return nameLivingArea;
    }

    public void setNameLivingArea(String nameLivingArea) {
        this.nameLivingArea = nameLivingArea;
    }

    public Woodwork getWoodwork() {
        return woodwork;
    }

    public void setWoodwork(Woodwork woodwork) {
        this.woodwork = woodwork;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }
}
