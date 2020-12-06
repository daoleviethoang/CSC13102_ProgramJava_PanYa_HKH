package PanyaCore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;
import org.json.JSONPropertyName;

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


    public BigDecimal getSellOff() {
        return sellOff;
    }

    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public void setSellOff(BigDecimal sellOff) {
        this.sellOff = sellOff;
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
    public static Menu parseMenuJSONObject(JSONObject menuJsonObject) {
        var menuDetail = menuJsonObject;
        try {
            menuDetail = (JSONObject) menuJsonObject.getJSONObject("menu");

            var sellOff = menuDetail.getBigDecimal("sellOf");
            var products = JsonDataUtils.toObjectList(menuDetail.getJSONArray("products"), Product::parseProductJSONObject);

            return new Menu(products,sellOff);

        } catch (NullPointerException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static List<Menu> readMenuList(String path)
    {
        return JsonDataUtils.readObjectList(path, Menu::parseMenuJSONObject);
    }
    public static boolean saveCustomProductList(String path, List<Menu> menu)
    {
        return JsonDataUtils.saveObjectList(path, menu, "menu", JSONObject::new);
    }
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        final String INPUT = "Panya/src/main/resources/data/ManageData/MenuFile.json";
        var menu = Menu.readMenuList(INPUT);

        final String OUTPUT = "Panya/src/main/resources/data/ManageData/sample-MenuFile.json";
        Menu.saveCustomProductList(OUTPUT, menu);
    }
}
