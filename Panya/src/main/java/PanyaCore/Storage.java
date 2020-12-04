package PanyaCore;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Storage {
    int capacity = 0;
    List<Ingredient> list = new ArrayList<Ingredient>();

    Storage() {
        this.capacity = 0;
    }

    Storage(int cap, List<Ingredient> l) {
        this.capacity = cap;
        this.list = new ArrayList<>(l);
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
     * Đọc từ file ra một List<Ingredient>
     * @param path Đường dẫn đến file json có định dạng để đọc ra một danh sách các Ingredient
     * @return List<Ingredient>, trả về <code>null</code> nếu file có vấn đề
     */
    public static List<Ingredient> readIngredients(String path) {
        JSONParser jsonParser = new JSONParser();

        try (var reader = new FileReader(path)) {
        
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            if (obj == null){
                return null;
            }

            JSONArray ingredientList = (JSONArray) obj;
            System.out.println(ingredientList.toJSONString());
            
            List<Ingredient> ingredients = new ArrayList<>();

            // Duyệt từng phần từ trong ingredientList, parse sang Ingredient, thêm vào danh sách ingredients
            ingredientList.forEach(emp -> ingredients.add(Ingredient.parseIngredientObject((JSONObject) emp)));

            return ingredients;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lưu List<Ingredient> sang file định dạng json
     * @param path đường dẫn đến file
     * @param list danh sách các ingredients
     * @return <code>true</code> nếu lưu file thành công, <code>false</code> cho các trường hợp khác
     */
    public static boolean writeIngredients(String path, List<Ingredient> list) {
        JSONArray ingredientJSON = new JSONArray();

        if (path == null || list == null){
            return false;
        }

        for (var ingredient : list) {
            JSONObject ingredientDetails = new JSONObject();
            ingredientDetails.put("id", ingredient.id);
            ingredientDetails.put("name", ingredient.name);
            ingredientDetails.put("quantity", ingredient.quantity.toString());
            ingredientDetails.put("unit", ingredient.unit);
            ingredientDetails.put("price", ingredient.price.toString());
            ingredientDetails.put("note", ingredient.note);
    
            JSONObject ingredientJSONObj = new JSONObject();
            ingredientJSONObj.put("ingredient", ingredientDetails);
            ingredientJSON.add(ingredientJSONObj);
        }

        try (var file = new FileWriter(path)) {
            // Chữa cháy, thư viện Kiệt xài không có in đẹp
            var temp = new org.json.JSONArray(ingredientJSON.toString());
            file.write(temp.toString(4));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        final String path = "src/main/resources/sample-data/sampleIngr.json";
        var ingredients = Storage.readIngredients(path);

        final String w_path = "src/main/resources/sample-data/sampleIngr-out.json";
        Storage.writeIngredients(w_path, ingredients);
    }
}
