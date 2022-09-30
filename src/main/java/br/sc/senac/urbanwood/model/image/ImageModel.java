package br.sc.senac.urbanwood.model.image;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class ImageModel {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_name")
    private String name;

    @Column(name = "image_type")
    private String type;

    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Column(name = "image_picByte", length = 1000)
    private byte[] picByte;

    public ImageModel() {
    }

    public ImageModel(Long id, String name, String type, byte[] picByte) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public ImageModel(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}