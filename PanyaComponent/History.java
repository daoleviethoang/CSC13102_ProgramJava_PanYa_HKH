import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class History {
    LocalDate date;
    List<Product> products = new ArrayList<>();

    public History(LocalDate date, List<Product> products){
        this.date = date;
        this.products = new ArrayList<>(products);
    }

    public History(History h){
        this.date = h.date;
        this.products = new ArrayList<>(products);
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

}
