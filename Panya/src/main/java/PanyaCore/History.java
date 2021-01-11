package PanyaCore;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;
import org.json.JSONPropertyName;

public class History {
    LocalDate date;
    List<Product> products = new ArrayList<>();

    public History(LocalDate date, List<Product> products) {
        this.date = date;
        this.products = new ArrayList<>(products);
    }

    public History(History h) {
        this.date = h.date;
        this.products = new ArrayList<>(products);
    }

    public LocalDate getDate() {
        return date;
    }

    @JSONPropertyIgnore
    public List<Product> getProducts() {
        return products;
    }

    @JSONPropertyName("products")
    public JSONArray getProductsJSONObject(){
        var productsJson = new JSONArray();
        products.forEach((obj)->{
            var productObj = new JSONObject(obj);
            productsJson.put(new JSONObject().put("product", productObj));
        });

        //var jsonObj = new JSONObject();
        //jsonObj.put("products", productsJson);
        return productsJson;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public void addProductToTodayHistory(List<Product> boughtProducts) {
        if (boughtProducts == null) {
            return;
        }
        for (var product : boughtProducts) {
            var idx = this.products.indexOf(product);
            if (idx != -1) {
                var thatProduct = this.products.get(idx);
                thatProduct.quantity += product.quantity;
            }
            else {
                this.products.add(product);
            }
        }
    }

    public static void addNewHistory(List<History> histories, List<Product> boughtProducts) {
        if (histories == null || boughtProducts == null) {
            return;
        }
        var today = LocalDate.now();
        var todayIdx = histories.indexOf(new History(today, new ArrayList<Product>()));
        if (todayIdx != -1) {
            histories.get(todayIdx).addProductToTodayHistory(boughtProducts);
            return;
        }
        histories.add(new History(today, boughtProducts));
    }

    @Override
    public boolean equals(Object obj) {
        return this.date.equals(((History) obj).date);
    }

    /**
     * Trả về một object đọc được từ {@link org.json.JSONObject}
     * 
     * <pre>
     * [
     *     {
     *         "history": {
     *             "products": [
     *                 {
     *                     "product": {
     *                         "id": "PYC-001",
     *                         "quantity": 10,
     *                         "price": "15.0",
     *                         "sellOff": "0.2"
     *                     }
     *                 }
     *             ],
     *             "date": "2020-05-12"
     *         }
     *     }
     * ]
     * </pre>
     * 
     * @param historyJsonObject JSONObject có các key có thể đọc được để tạo object
     * @return object <code>History</code>, trả về <code>null</code> nếu
     *         <code>historyJsonObject</code> không có key hợp lệ
     * 
     */
    public static History parseHistoryJSONObject(JSONObject historyJsonObject) {
        var historyDetail = historyJsonObject;
        try {
            historyDetail = (JSONObject) historyJsonObject.getJSONObject("history");

            var date = LocalDate.parse(historyDetail.getString("date"));
            var products = JsonDataUtils.toObjectList(historyDetail.getJSONArray("products"), Product::parseProductJSONObject);

            return new History(date, products);

        } catch (NullPointerException | JSONException | DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Đọc từ file ra một <code>List<History></code> định dạng
     * <code>json</code> của có dạng sau:
     * 
     * <pre>
     * [
     *     {
     *         "history": {
     *             "products": [
     *                 {
     *                     "product": {
     *                         "id": "PYC-001",
     *                         "quantity": 10,
     *                         "price": "15.0",
     *                         "sellOff": "0.2"
     *                     }
     *                 }
     *             ],
     *             "date": "2020-05-12"
     *         }
     *     }
     * ]
     * </pre>
     * 
     * Trong đó, mỗi object History được parse ra từ static method
     * {@link PanyaCore.History#parseHistoryJSONObject(JSONObject)}
     * 
     * @param path Đường dẫn đến file json có định dạng để đọc ra một danh sách các
     *             History
     * @return List<History>, trả về <code>null</code> nếu file có vấn đề
     * @see  PanyaCore.History#parseHistoryJSONObject(JSONObject)
     */
    public static List<History> readHistoryList(String path) {
        return JsonDataUtils.readObjectList(path, History::parseHistoryJSONObject);
    }

    /**
     * Lưu List<History> sang file định dạng json
     * 
     * @param path     đường dẫn đến file cần lưu
     * @param history danh sách các History
     * @return <code>true</code> nếu lưu file thành công, <code>false</code> cho các
     *         trường hợp khác
     */
    public static boolean saveHistoryList(String path, List<History> history) {
        return JsonDataUtils.saveObjectList(path, history, "history", JSONObject::new);
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        final String INPUT = "Panya/src/main/resources/data/ManageData/HistoryFile.json";
        var history = History.readHistoryList(INPUT);

        final String OUTPUT = "Panya/src/main/resources/data/ManageData/sample-HistoryFile.json";
        History.saveHistoryList(OUTPUT, history);
    }
}
