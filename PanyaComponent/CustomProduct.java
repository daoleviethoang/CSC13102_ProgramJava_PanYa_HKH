import java.math.BigDecimal;

public class CustomProduct extends Product {
    BigDecimal customPrice;
    String customerName;
    String customerPhoneNumber;

    public CustomProduct(
        String name, String id, String note, BigDecimal price, BigDecimal sellOff, int quantity,
        BigDecimal customPrice, String customerName, String customerPhoneNumber){
        
        super(name, id, note, price, sellOff, quantity);
        this.customPrice = customPrice;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public CustomProduct(CustomProduct c){
        super(c);
        this.customPrice = c.customPrice;
        this.customerName = c.customerName;
        this.customerPhoneNumber = c.customerPhoneNumber;
    }

    public BigDecimal getCustomPrice() {
        return customPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomPrice(BigDecimal customPrice) {
        this.customPrice = customPrice;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
