package PanyaCore;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;
import org.json.JSONPropertyName;

public class CustomProduct extends Product {
    BigDecimal customPrice;
    String customerName;
    String customerPhoneNumber;

    public CustomProduct(String name, String id, String note, BigDecimal price, BigDecimal sellOff, int quantity,
            BigDecimal customPrice, String customerName, String customerPhoneNumber) throws NullPointerException {

        super(name, id, price, quantity, sellOff, note);
        this.customPrice = customPrice;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public CustomProduct(CustomProduct c) {
        super(c);
        this.customPrice = c.customPrice;
        this.customerName = c.customerName;
        this.customerPhoneNumber = c.customerPhoneNumber;
    }

    public CustomProduct(BigDecimal customPrice, String customerName, String customerPhoneNumber, Product product)
            throws NullPointerException {
        super(product);
        this.customPrice = customPrice;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    @JSONPropertyIgnore
    public BigDecimal getCustomPrice() {
        return customPrice;
    }

    @JSONPropertyName("customPrice")
    public String getCustomPriceString() {
        return customPrice.toString();
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

    /**
     * Trả về một object đọc được từ {@link org.json.JSONObject}
     * 
     * <pre>
     *  "customProduct": {
     *     "customerName": "ホアン・スアン・キエット",
     *     "customerPhoneNumber": "0785625757",
     *     "customerAddress": "チャンボム県、 ドンナイ省、 ベトナム",
     *     "customPrice": "1000.0",
     *     "id": "CUS-001",
     *     "name": "Donut (for Kiet-sama)",
     *     "price": "15.0",
     *     "quantity": "20",
     *     "sellOff": "0",
     *     "note": "Special order for a birthday party"
     * }
     * </pre>
     *
     * @param cProductJson JSONObject có các key có thể đọc được để tạo object
     * @return object <code>Product</code>, trả về <code>null</code> nếu
     *         <code>cProductJson</code> không có key hợp lệ
     */
    public static CustomProduct parseCustomProductJSONObject(JSONObject cProductJson) {
        try {
            var productDetail = (JSONObject) cProductJson.get("customProduct");
            var customerName = productDetail.getString("customerName");
            var customerPhoneNumber = productDetail.getString("customerPhoneNumber");
            var customPrice = new BigDecimal(productDetail.getString("customPrice"));
            var product = Product.parseProductJSONObject(productDetail);

            return new CustomProduct(customPrice, customerName, customerPhoneNumber, product);

        } catch (NullPointerException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Đọc từ file ra một <code>List<CustomProduct></code> định dạng
     * <code>json</code> của có dạng sau:
     * 
     * <pre>
     * [
     *     {
     *         "customProduct": {
     *             "customerName": "value",
     *             "customerPhoneNumber": "value",
     *             "customerAddress": "value",
     *             "customPrice": "value",
     *             "id": "value",
     *             "name": "value",
     *             "price": "value",
     *             "quantity": "value",
     *             "sellOff": "value",
     *             "note": "value"
     *         }
     *     },
     *     {
     *         "customProduct": {...}
     *     },
     *     ...
     *  ]
     * </pre>
     * 
     * Trong đó, mỗi object CustomProduct được parse ra từ static method
     * {@link PanyaCore.CustomProduct#parseProductJSONObject(JSONObject)}
     * 
     * @param path Đường dẫn đến file json có định dạng để đọc ra một danh sách các
     *             CustomProduct
     * @return List<CustomProduct>, trả về <code>null</code> nếu file có vấn đề
     * @see PanyaCore.Product#parseCustomProductJSONObject(JSONObject)
     */
    public static List<CustomProduct> readCustomProductList(String path) {
        return JsonDataUtils.readObjectList(path, CustomProduct::parseCustomProductJSONObject);
    }

    /**
     * Lưu List<CustomProduct> sang file định dạng json
     * 
     * @param path     đường dẫn đến file cần lưu
     * @param products danh sách các products
     * @return <code>true</code> nếu lưu file thành công, <code>false</code> cho các
     *         trường hợp khác
     */
    public static boolean saveCustomProductList(String path, List<CustomProduct> products) {
        return JsonDataUtils.saveObjectList(path, products, "customProduct", JSONObject::new);
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        final String INPUT = "Panya/src/main/resources/data/ManageData/CustomerProductFile.json";
        var products = CustomProduct.readCustomProductList(INPUT);

        final String OUTPUT = "Panya/src/main/resources/data/ManageData/sample-CustomerProductFile.json";
        CustomProduct.saveCustomProductList(OUTPUT, products);
    }
}
