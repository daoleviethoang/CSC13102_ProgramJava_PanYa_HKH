package Library;

import java.math.BigDecimal;

public class Ingredient{
    String id;
    String name;
    double quantity;
    String unit;
    BigDecimal price;
    String note;
    Ingredient()
    {
        this.id = "";
        this.name = "";
        this.quantity = 0;
        this.unit = "";
        this.price = BigDecimal.ZERO;
        this.note = "";
    }
    Ingredient(String id, String name, double quantity, String unit, BigDecimal p, String note)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.price = p;
        this.note = note;
    }
    Ingredient(Ingredient i)
    {
        this.id = i.getId();
        this.name =i.getName();
        this.quantity = i.getQuantity();
        this.unit = i.getUnit();
        this.price = i.getPrice();
        this.note = i.getNote();
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getUnit() {
        return unit;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }
}