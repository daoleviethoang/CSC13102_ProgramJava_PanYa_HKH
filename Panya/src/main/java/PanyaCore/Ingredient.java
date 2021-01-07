package PanyaCore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;
import org.json.JSONPropertyName;

public class Ingredient {
    String id;
    String name;
    BigDecimal quantity;
    String unit;
    BigDecimal price;
    String note;
    private int count_sta = 0;
    Ingredient() {
        this.id = "";
        this.name = "";
        this.quantity = BigDecimal.ZERO;
        this.unit = "";
        this.price = BigDecimal.ZERO;
        this.note = "";
    }

    Ingredient(String id, String name, BigDecimal quantity, String unit, BigDecimal price, String note)
            throws NullPointerException {

        this.id = Objects.requireNonNull(id);
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
        this.note = note;
    }

    Ingredient(Ingredient i) {
        this.id = i.getId();
        this.name = i.getName();
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

    @JSONPropertyIgnore
    public BigDecimal getQuantity() {
        return quantity;
    }

    @JSONPropertyName("quantity")
    public String getQuantityString() {
        return quantity.toString();
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    @JSONPropertyIgnore
    public BigDecimal getPrice() {
        return price;
    }

    @JSONPropertyName("price")
    public String getPriceString() {
        return price.toString();
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

    /**
     * Trả về một object đọc được từ {@link org.json.JSONObject}
     * 
     * <pre>
     * "ingredient": {
     *     "note": "value",
     *     "unit": "value",
     *     "quantity": "value",
     *     "price": "value",
     *     "name": "value",
     *     "id": "value"
     * }
     * </pre>
     * 
     * @param ingredient object có các key có thể đọc được để tạo object Ingredient
     * @return object Ingredient, trả về <code>null</code> nếu
     *         <code>ingredient</code> không có key hợp lệ
     * @see org.json.JSONObject
     */
    static Ingredient parseIngredientObject(JSONObject ingredient) {

        JSONObject ingredientObject = ingredient;
        try {
            ingredientObject = (JSONObject) ingredient.get("product");
        } catch (JSONException ignored) {
        }

        try {

            var id = ingredientObject.getString("id");
            var name = ingredientObject.optString("name", null);
            var quantity = ingredientObject.optBigDecimal("quantity", null);
            var unit = ingredientObject.optString("unit", null);
            var price = ingredientObject.optBigDecimal("price", null);
            var note = ingredientObject.optString("note", null);
            return new Ingredient(id, name, quantity, unit, price, note);

        } catch (NullPointerException | JSONException e) {
            return null;
        }
    }


    /**
     * Đọc từ file ra một List<Ingredient> Định dạng json của file cần đọc có dạng
     * sau:
     * 
     * <pre>
     * [
     *     {
     *         "ingredient": {
     *             "note": "value",
     *             "unit": "value",
     *             "quantity": "value",
     *             "price": "value",
     *             "name": "value",
     *             "id": "value"
     *         }
     *     },
     *     {
     *         "ingredient": {}
     *     }
     *     ...
     * ]
     * </pre>
     * 
     * Trong đó, mỗi object nguyên liệu được parse ra từ static method
     * {@link PanyaCore.Ingredient#parseIngredientObject(JSONObject)}
     * 
     * @param path Đường dẫn đến file json có định dạng để đọc ra một danh sách các
     *             Ingredient
     * @return List<Ingredient>, trả về <code>null</code> nếu file có vấn đề
     * @see PanyaCore.Ingredient#parseIngredientObject(JSONObject)
     */
    public static List<Ingredient> readIngredients(String path) {

        try {
            // Đọc toàn bộ các bytes trong một file, tạo String
            var fileContent = new String(Files.readAllBytes(Path.of(path)));
            var ingredientList = new JSONArray(fileContent);

            System.out.println(ingredientList.toString(4));

            List<Ingredient> ingredients = new ArrayList<>();

            // Duyệt từng phần từ trong ingredientList, parse sang Ingredient, thêm vào danh
            // sách ingredients
            ingredientList.forEach(emp -> ingredients.add(Ingredient.parseIngredientObject((JSONObject) emp)));

            return ingredients;
        } catch (OutOfMemoryError | IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lưu List<Ingredient> sang file định dạng json
     * 
     * @param path đường dẫn đến file
     * @param list danh sách các ingredients
     * @return <code>true</code> nếu lưu file thành công, <code>false</code> cho các
     *         trường hợp khác
     */
    public static boolean writeIngredients(String path, List<Ingredient> list) {
        var ingredientJSON = new JSONArray();

        if (path == null || list == null) {
            return false;
        }

        for (var ingredient : list) {
            var ingredientDetails = new JSONObject(ingredient);
        
            JSONObject ingredientJSONObj = new JSONObject();
            ingredientJSONObj.put("ingredient", ingredientDetails);
            ingredientJSON.put(ingredientJSONObj);
        }

        try (var file = new FileWriter(path)) {
            file.write(ingredientJSON.toString(4));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        final String path = "Panya/src/main/resources/data/IngredientData/IngredientFile.json";
        var ingredients = Ingredient.readIngredients(path);

        final String w_path = "Panya/src/main/resources/data/IngredientData/sample-IngredientFile.json";
        Ingredient.writeIngredients(w_path, ingredients);
    }
    public int getCount_sta() {
        return count_sta;
    }
    public void setCount_sta(int count_sta) {
        this.count_sta = count_sta;
    }
    public void plus_count(int x) {
        int c = this.getCount_sta() + x;
        this.setCount_sta(c);
    }
}