package com.codecool.itemservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int price;
    private boolean available;
    private String img;

    @Temporal(TemporalType.DATE)
    private Date uploadDate;

    private long sellerId;

    public Item(String name, int price, boolean available, String img, Date uploadDate, long sellerId) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.img = img;
        this.uploadDate = uploadDate;
        this.sellerId = sellerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }
}
