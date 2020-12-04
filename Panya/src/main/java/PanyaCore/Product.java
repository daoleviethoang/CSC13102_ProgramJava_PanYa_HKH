package PanyaCore;

import java.math.BigDecimal;

public class Product {
    protected String name;
    protected String id;
    protected String note;
    protected BigDecimal price;
    protected BigDecimal sellOff;
    protected int quantity;

    public Product(String name, String id, String note, BigDecimal price, BigDecimal sellOff, int quantity) {
        this.name = name;
        this.id = id;
        this.note = note;
        this.price = price;
        this.sellOff = sellOff;
        this.quantity = quantity;
    }

    public Product(Product p) {
        this.name = p.name;
        this.id = p.id;
        this.note = p.note;
        this.price = p.price;
        this.sellOff = p.sellOff;
        this.quantity = p.quantity;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSellOff() {
        return sellOff;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSellOff(BigDecimal sellOff) {
        this.sellOff = sellOff;
    }

}