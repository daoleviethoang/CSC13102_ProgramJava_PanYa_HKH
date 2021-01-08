package PanyaCore;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;
import org.json.JSONPropertyName;

public class Product {
    protected String name;
    protected String id;
    protected String note;
    protected BigDecimal price;
    protected BigDecimal sellOff;
    protected int quantity;
    protected String image;

    public Product(String id, String name, BigDecimal price, int quantity, BigDecimal sellOff,  String note, String image)
            throws NullPointerException {

        this.id = Objects.requireNonNull(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sellOff = sellOff;
        this.note = note;
        this.image = image;
    }

    public Product(Product p) {
        this.id = p.id;
        this.name = p.name;
        this.price = p.price;
        this.quantity = p.quantity;
        this.sellOff = p.sellOff;
        this.note = p.note;
        this.image = p.image;
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
    public String getImage(){
        return image;
    }
    @JSONPropertyIgnore
    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @JSONPropertyIgnore
    public BigDecimal getSellOff() {
        return sellOff;
    }

    @JSONPropertyName("sellOff")
    public String getSellOffString() {
        return this.sellOff.toString();
    }

    @JSONPropertyName("price")
    public String getPriceString() {
        return this.price.toString();
    }

    public void setId(String id) throws NullPointerException {
        this.id = Objects.requireNonNull(id);
    }

    public void setName(String name) throws NullPointerException {
        this.name = Objects.requireNonNull(name);
    }

    public void setNote(String note) throws NullPointerException {
        this.note = Objects.requireNonNull(note);
    }

    public void setPrice(BigDecimal price) throws NullPointerException {
        this.price = Objects.requireNonNull(price);
    }

    public void setQuantity(int quantity) throws NullPointerException {
        this.quantity = Objects.requireNonNull(quantity);
    }

    public void setSellOff(BigDecimal sellOff) throws NullPointerException {
        this.sellOff = Objects.requireNonNull(sellOff);
    }
    public void setImage(String image) throws NullPointerException{
        this.image = Objects.requireNonNull(image);
    }
    /**
     * Đọc từ file ra một <code>List<Product></code> định dạng <code>json</code> của
     * có dạng sau:
     * 
     * <pre>
     * [
     *     {
     *         "product": {
     *             "id": "value",
     *             "name": "value",
     *             "price": "value",
     *             "quantity": "value",
     *             "sellOff": "value",
     *             "note": "value"
     *         }
     *     },
     *     {
     *         "product": {...}
     *     },
     *     ...
     *  ]
     * </pre>
     * 
     * Trong đó, mỗi object Product được parse ra từ static method
     * {@link PanyaCore.Product#parseProductJSONObject(JSONObject)}
     * 
     * @param path Đường dẫn đến file json có định dạng để đọc ra một danh sách các
     *             Product
     * @return List<Product>, trả về <code>null</code> nếu file có vấn đề
     * @see PanyaCore.Product#parseProductJSONObject(JSONObject)
     */
    public static List<Product> readProductList(String path) {
        return JsonDataUtils.readObjectList(path, Product::parseProductJSONObject);
    }

    /**
     * Trả về một object đọc được từ {@link org.json.JSONObject}
     * 
     * <pre>
     *  {
     *     "product": {
     *         "id": "PYC-001",
     *         "name": "Donut",
     *         "price": "15.0",
     *         "quantity": "10",
     *         "sellOff": "0.2",
     *         "note": "Fried dough confection or dessert food"
     *     }
     * }
     * </pre>
     * 
     * @param productJson JSONObject có các key có thể đọc được để tạo object
     * @return object <code>Product</code>, trả về <code>null</code> nếu
     *         <code>productJson</code> không có key hợp lệ
     */
    public static Product parseProductJSONObject(JSONObject productJson) {

        JSONObject productDetail = productJson;
        try {
            productDetail = (JSONObject) productJson.get("product");
        } catch (JSONException ignored) {
        }

        try {

            var id = productDetail.getString("id");
            var name = productDetail.optString("name", null);
            var price = productDetail.optBigDecimal("price", null);
            var quantity = productDetail.optInt("quantity", -1);
            var sellOff = productDetail.optBigDecimal("sellOff", null);

            var note = productDetail.optString("note", null);
            var image = productDetail.optString("image", null);
            return new Product(id, name, price, quantity, sellOff, note, image);
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lưu List<Product> sang file định dạng json
     * 
     * @param path     đường dẫn đến file cần lưu
     * @param products danh sách các products
     * @return <code>true</code> nếu lưu file thành công, <code>false</code> cho các
     *         trường hợp khác
     */
    public static boolean saveProductList(String path, List<Product> products) {
        return JsonDataUtils.saveObjectList(path, products, "product", JSONObject::new);
    }

    // public static void main(String[] args) {
    //     System.out.println("Working Directory = " + System.getProperty("user.dir"));

    //     final String INPUT = "Panya/src/main/resources/data/ManageData/ProductFile.json";
    //     var products = Product.readProductList(INPUT);

    //     final String OUTPUT = "Panya/src/main/resources/data/ManageData/sample-ProductFile.json";
    //     Product.saveProductList(OUTPUT, products);
    // }

}