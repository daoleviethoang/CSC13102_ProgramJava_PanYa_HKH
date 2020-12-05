package PanyaCore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Product> products = new ArrayList<>();
    BigDecimal sellOff = BigDecimal.ZERO;

    public Menu(List<Product> products, BigDecimal sellOff) {
        this.products = new ArrayList<>(products);
        this.sellOff = sellOff;
    }

    public Menu(Menu m) {
        this.products = new ArrayList<>(m.products);
        this.sellOff = m.sellOff;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getSellOff() {
        return sellOff;
    }

    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public void setSellOff(BigDecimal sellOff) {
        this.sellOff = sellOff;
    }

}
