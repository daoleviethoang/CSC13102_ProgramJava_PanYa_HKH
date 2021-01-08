package PanyaCore;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;
import org.json.JSONPropertyName;

public class Recipe {
    String id;
    String name;
    List<String> productId = new ArrayList<String>();
    List<Ingredient> ingredient = new ArrayList<Ingredient>();
    String description;
    String note;
    boolean visibility = false;

    public Recipe() {
        this.id = "";
        this.name = "";
        this.description = "";
        this.note = "";
    }

    public Recipe(String id, String name, List<String> proId, List<Ingredient> ingre, String des, String note,
            boolean vision) {
        this.id = id;
        this.name = name;
        this.productId = new ArrayList<>(proId);
        this.ingredient = new ArrayList<>(ingre);
        this.description = des;
        this.note = note;
        this.visibility = vision;
    }

    public Recipe(Recipe r) {
        this.id = r.getId();
        this.name = r.getName();
        this.productId = new ArrayList<>(r.getProductId());
        this.ingredient = new ArrayList<>(r.getIngredient());
        this.description = r.getDescription();
        this.note = r.getNote();
        this.visibility = r.getVisibility();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProductId() {
        return productId;
    }

    public void setProductId(List<String> productId) {
        this.productId = new ArrayList<>(productId);
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = new ArrayList<>(ingredient);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean getVisibility() {
        return this.visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    @JSONPropertyIgnore
    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    @JSONPropertyName("ingredients")
    public JSONArray getIngredientsJSONObject() {
        var ingredientsJson = new JSONArray();
        ingredient.forEach((obj) -> ingredientsJson.put(new JSONObject(obj)));
        return ingredientsJson;
    }

    public static Recipe parseRecipeJSONObject(JSONObject recipeJsonObject) {
        var recipeDetail = (JSONObject) recipeJsonObject.getJSONObject("recipe");
        try {
            var id = recipeDetail.getString("id");
            var name = recipeDetail.getString("name");
            var visibility = recipeDetail.getBoolean("visibility");
            var description = recipeDetail.getString("description");
            var note = recipeDetail.getString("note");

            var productIdObj = recipeDetail.getJSONArray("productId").toList();
            var productId = new ArrayList<String>(productIdObj.size());
            for (var obj : productIdObj) {
                productId.add(Objects.toString(obj));
            }

            var ingredients = JsonDataUtils.toObjectList(recipeDetail.getJSONArray("ingredients"),
                    Ingredient::parseIngredientObject);
            return new Recipe(id, name, productId, ingredients, description, note, visibility);

        } catch (NullPointerException | JSONException | DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Recipe> readRecipeList(String path) {
        return JsonDataUtils.readObjectList(path, Recipe::parseRecipeJSONObject);
    }

    public static boolean saveRecipeList(String path, List<Recipe> recipes) {
        return JsonDataUtils.saveObjectList(path, recipes, "recipe", JSONObject::new);
    }

    public static int getLastId(List<Recipe> recipes) {
        int lastId = 0;
        for (var recipe : recipes) {
            var id = Integer.parseInt(recipe.id.replaceAll("[^0-9]", "")); 
            lastId = id > lastId? id: lastId;
        }
        return lastId;
    }

    public static String nextId(List<Recipe> recipes) {
        return "REC-" + getLastId(recipes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            return this.id.equals(obj);
        }
        return this.id.equals(((Recipe)obj).id);
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        final String INPUT = "Panya/src/main/resources/data/RecipeData/RecipeFile-out.json";
        var recipe = Recipe.readRecipeList(INPUT);

        final String OUTPUT = "Panya/src/main/resources/data/RecipeData/RecipeFile-out.json";
        Recipe.saveRecipeList(OUTPUT, recipe);
    }
}