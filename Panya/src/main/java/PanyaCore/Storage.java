package PanyaCore;

import java.util.ArrayList;
import java.util.List;

//import org.json.JSONPropertyName;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.io.FileWriter;
import org.json.simple.*;

import org.json.simple.parser.*;

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

    public void readFile(String path) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray ingredientList = (JSONArray) obj;
            System.out.println(ingredientList);

            // Iterate over employee array
            ingredientList.forEach(emp -> parseIngredientObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseIngredientObject(JSONObject ingredient) {

        JSONObject ingredientObject = (JSONObject) ingredient.get("ingredient");

        String id = (String) ingredientObject.get("id");
        String name = (String) ingredientObject.get("name");
        Double quantity = (Double) ingredientObject.get("quantity");
        String unit = (String) ingredientObject.get("unit");
        BigDecimal price = (BigDecimal) ingredientObject.get("price");

        String note = (String) ingredientObject.get("note");
        Ingredient temp = new Ingredient(id, name, quantity, unit, price, note);

        list.add(temp);
        capacity++;
    }

    public void writeFile(String path) {
        JSONArray employeeList = new JSONArray();
        for (int i = 0; i < capacity; i++) {
            JSONObject ingredientDetails = new JSONObject();
            ingredientDetails.put("id", list.get(0).id);
            ingredientDetails.put("name", list.get(0).name);
            ingredientDetails.put("quantity", list.get(0).quantity);
            ingredientDetails.put("unit", list.get(0).unit);
            ingredientDetails.put("price", list.get(0).price.toString());
            ingredientDetails.put("note", list.get(0).note);

            JSONObject employeeObject = new JSONObject();
            employeeObject.put("ingredient", ingredientDetails);
            employeeList.add(employeeObject);
        }

        try (FileWriter file = new FileWriter(path)) {

            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}