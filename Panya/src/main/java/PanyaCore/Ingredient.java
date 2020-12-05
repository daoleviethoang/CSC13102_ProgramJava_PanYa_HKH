package PanyaCore;

import java.math.BigDecimal;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Ingredient {
    String id;
    String name;
    BigDecimal quantity;
    String unit;
    BigDecimal price;
    String note;

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
        this.name = Objects.requireNonNull(name);
        this.quantity = Objects.requireNonNull(quantity);
        this.unit = Objects.requireNonNull(unit);
        this.price = Objects.requireNonNull(price);
        this.note = Objects.requireNonNull(note);
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

    public BigDecimal getQuantity() {
        return quantity;
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

    public BigDecimal getPrice() {
        return price;
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
     * @param ingredient object có các key có thể đọc được để tạo object Ingredient
     * @return object Ingredient, trả về <code>null</code> nếu
     *         <code>ingredient</code> không có key hợp lệ
     * @see org.json.JSONObject
     */
    static Ingredient parseIngredientObject(JSONObject ingredient) {
        
        try {
            
            JSONObject ingredientObject = (JSONObject) ingredient.get("ingredient");
            var id = (String) ingredientObject.get("id");
            var name = (String) ingredientObject.get("name");
            var quantity = new BigDecimal((String) ingredientObject.get("quantity"));
            var unit = (String) ingredientObject.get("unit");
            var price = new BigDecimal((String) ingredientObject.get("price"));
            var note = (String) ingredientObject.get("note");
            return new Ingredient(id, name, quantity, unit, price, note);

        } catch (NullPointerException | JSONException e) {
            return null;
        }
    }
}