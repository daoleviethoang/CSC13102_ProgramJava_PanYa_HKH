package PanyaCore;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter;

/**
 * Object Storage quản lý nhà kho trong phần mềm Pan-ya
 */
public class Storage {
    int capacity = 0;
    List<Ingredient> list = new ArrayList<Ingredient>();

    Storage() {
        this.capacity = 0;
    }

    /**
     * Constructor cho một object Storage
     * 
     * @param cap dung tích tối đa của nhà kho
     * @param l   List<Ingredient> là một danh các nguyên liệu (Ingredient) hiện có
     * @throws NullPointerException khi l <code>null</code>
     * @see PanyaCore.Ingredient
     */
    Storage(int cap, List<Ingredient> l) throws NullPointerException {
        this.capacity = cap;
        try {
            this.list = new ArrayList<>(l);
        } catch (NullPointerException e) {
            throw e;
        }
    }

    Storage(Storage s) {
        this.capacity = s.getCapacity();
        this.list = new ArrayList<>(s.getList());
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Ingredient> getList() {
        return list;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setList(List<Ingredient> list) {
        this.list = new ArrayList<>(list);
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
            var ingredientDetails = new JSONObject();
            ingredientDetails.put("id", ingredient.id);
            ingredientDetails.put("name", ingredient.name);
            ingredientDetails.put("quantity", ingredient.quantity.toString());
            ingredientDetails.put("unit", ingredient.unit);
            ingredientDetails.put("price", ingredient.price.toString());
            ingredientDetails.put("note", ingredient.note);

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

        final String path = "Panya/src/main/resources/sample-data/sample-ingr.json";
        var ingredients = Storage.readIngredients(path);

        final String w_path = "Panya/src/main/resources/sample-data/sample-ingr-out.json";
        Storage.writeIngredients(w_path, ingredients);
    }
}
