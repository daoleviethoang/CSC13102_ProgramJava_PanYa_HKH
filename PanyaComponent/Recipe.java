import java.util.ArrayList;
import java.util.List;

public class Recipe {
    String id;
    String name;
    List<String> productId = new ArrayList<String>();
    List<Ingredient> ingredient = new ArrayList<Ingredient>();
    String description;
    String note;
    boolean visibility = false;

    Recipe() {
        this.id = "";
        this.name = "";
        this.description = "";
        this.note = "";
    }

    Recipe(String id, String name, List<String> proId, List<Ingredient> ingre, String des, String note,
            boolean vision) {
        this.id = id;
        this.name = name;
        this.productId = new ArrayList<>(proId);
        this.ingredient = new ArrayList<>(ingre);
        this.description = des;
        this.note = note;
        this.visibility = vision;
    }

    Recipe(Recipe r) {
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

    public List<Ingredient> getIngredient() {
        return ingredient;
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
}