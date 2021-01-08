package PanyaUI.RecipeUI;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.math.BigDecimal;

import PanyaCore.Ingredient;
import PanyaCore.Recipe;
import PanyaUI.Theme;

public class RecipeWindow extends RecipeWindowBase {

    /**
     *
     */
    private static final long serialVersionUID = 5264686455325416561L;
    DefaultTableModel ingredientsTableModel;

    Recipe recipe;
    List<Ingredient> allIngredients;
    String ingredientFile;
    JTextField idTextField;
    RecipeMainPanel parent;

    public RecipeWindow(Color primary, Color light, Color dark, boolean randomColor, String ingredientFile,
            RecipeMainPanel parent) {
        super(primary, light, dark, randomColor);

        this.parent = parent;

        this.ingredientsTableModel = (DefaultTableModel) this.ingredientTable.getModel();
        this.ingredientFile = ingredientFile;
        this.allIngredients = Ingredient.readIngredients(ingredientFile);

        // Hack: trong Netbeans để 4 dòng table trống, xóa nó đi để load data thật
        for (int i = 0; i < 4; i++) {
            this.ingredientsTableModel.removeRow(0);
        }
        this.idTextField = new JTextField("ID");
        this.initButton();
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    void initButton() {
        this.setActionForAddIngredientFrame();

        this.addIngredientButton.addActionListener(e -> {
            this.UnitCombo.setModel(new DefaultComboBoxModel<String>());
            this.quantityField.setText("");

            this.addIngredientFrame.setVisible(true);
            var selectedIngredients = new ArrayList<String>();
            for (var ingredient : allIngredients) {
                if (!this.recipe.getIngredient().contains(ingredient)) {
                    selectedIngredients.add(ingredient.getId() + " | " + ingredient.getName());
                }
            }

            this.ingredientNameCombo
                    .setModel(new DefaultComboBoxModel<String>(selectedIngredients.toArray(String[]::new)));
        });

        this.removeIngredientButton.addActionListener(e -> {
            var idx = this.ingredientTable.getSelectedRow();
            if (idx == -1) {
                return;
            }
            this.recipe.getIngredient().remove(idx);
            this.ingredientsTableModel.removeRow(idx);

        });

        this.saveButton.addActionListener(e -> {

            this.getRecipeFromWindow();

            var name = this.recipe.getName();
            if (name == null || name.isEmpty()) {
                JOptionPane.showMessageDialog(this.addIngredientFrame,
                        "Please input a valid name in the name text field", "Empty name", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (this.parent != null) {
                this.recipe.setId(Recipe.nextId(this.parent.recipes));
                this.parent.recipes.add(recipe);
                this.parent.recipeModel
                        .addRow(new Object[] { this.recipe.getId(), this.recipe.getName(), this.recipe.getNote() });
                Recipe.saveRecipeList(this.parent.recipeFile, this.parent.recipes);
                this.setVisible(false);

            }

        });

        this.editButton.addActionListener(e -> {
            if (editButton.getText().equals("Edit")) {
                // Change to the edit state, change the button to "Save"
                this.setEditable(true);
                this.editButton.setText("Save");

            } else {
                this.getRecipeFromWindow();

                var name = this.recipe.getName();
                if (name == null || name.isEmpty()) {
                    JOptionPane.showMessageDialog(this.addIngredientFrame,
                            "Please input a valid name in the name text field", "Empty name",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (this.parent != null) {
                    // TODO: Do something, i'm hungry :<
                    var idx = this.parent.recipes.indexOf(this.recipe);
                    if (idx == -1) {
                        return;
                    }
                    this.parent.recipes.set(idx, this.recipe);

                    var model = this.parent.recipeModel;

                    // Gán cứng chữa cháy
                    model.setValueAt(this.recipe.getId(), idx, 0);
                    model.setValueAt(this.recipe.getName(), idx, 1);
                    model.setValueAt(this.recipe.getNote(), idx, 2);
                    Recipe.saveRecipeList(this.parent.recipeFile, this.parent.recipes);

                    editButton.setText("Edit");
                    this.setVisible(false);

                }
            }
        });

        this.removeButton.addActionListener(e -> {
            var confirm = JOptionPane.showConfirmDialog(this.addIngredientFrame,
                    "Do you really want to remove this recipe", "Remove recipe confirmations",
                    JOptionPane.YES_NO_OPTION);
            if (confirm != 0) {
                return;
            }

            // È difficile stare al mondo :<
            var idx = this.parent.recipes.indexOf(this.recipe);
            this.parent.recipes.remove(this.recipe);

            this.parent.recipeModel.removeRow(idx);
            Recipe.saveRecipeList(this.parent.recipeFile, this.parent.recipes);

            this.setVisible(false);

        });
    }

    void setEditable(boolean b) {
        this.nameTextField.setEditable(b);
        this.descriptionTextField.setEditable(b);
        // this.ingredientsTableModel.setEditable(b);
        this.addIngredientButton.setEnabled(b);
        this.removeIngredientButton.setEnabled(b);
        this.saveButton.setEnabled(b);
        this.secretRecipeCheckBox.setEnabled(b);
        this.addIngredientButton.setEnabled(b);
        this.removeIngredientButton.setEnabled(b);
    }

    void clear() {
        this.nameTextField.setText("");
        this.descriptionTextField.setText("");
        this.secretRecipeCheckBox.setSelected(false);

        while (this.ingredientTable.getRowCount() != 0) {
            this.ingredientsTableModel.removeRow(0);
        }

    }

    public void addNewRecipeView() {
        this.clear();
        this.saveButton.setVisible(true);
        this.editButton.setVisible(false);
        this.removeButton.setVisible(false);
        this.setEditable(true);
        this.recipe = new Recipe();

    }

    public void viewAndEditRecipeView(Recipe r) {
        this.clear();
        this.setVisible(true);
        this.saveButton.setVisible(false);
        this.editButton.setVisible(true);
        this.removeButton.setVisible(true);
        this.editButton.setText("Edit");
        this.setEditable(false);
        this.loadRecipe(r);
    }

    void getRecipeFromWindow() {

        var id = this.idTextField.getText();
        var name = this.nameTextField.getText();
        var description = this.descriptionTextField.getText();
        var visibility = !secretRecipeCheckBox.isSelected();
        List<Ingredient> ingredients = new ArrayList<>();

        for (int i = 0; i < this.ingredientsTableModel.getRowCount(); i++) {
            var ingredientId = (String) this.ingredientsTableModel.getValueAt(i, 0);
            var quantity = new BigDecimal((String) this.ingredientsTableModel.getValueAt(i, 2));
            var unit = (String) this.ingredientsTableModel.getValueAt(i, 3);
            var note = (String) this.ingredientsTableModel.getValueAt(i, 4);
            ingredients.add(new Ingredient(ingredientId, "", quantity, unit, null, note));
        }

        this.recipe = new Recipe(id, name, new ArrayList<String>(), ingredients, description, "", visibility);
    }

    void loadRecipe(Recipe r) {
        this.recipe = r;
        this.idTextField.setText(r.getId());
        this.nameTextField.setText(r.getName());
        this.descriptionTextField.setText(r.getDescription());
        this.secretRecipeCheckBox.setSelected(!r.getVisibility());

        // int rowCount = 0;
        for (var i : r.getIngredient()) {
            var idx = allIngredients.indexOf(i);
            var name = idx != -1 ? allIngredients.get(idx).getName() : "";
            this.ingredientsTableModel
                    .addRow(new Object[] { i.getId(), name, i.getQuantity().toString(), i.getUnit(), i.getNote() });
        }
    }

    void setActionForAddIngredientFrame() {
        this.ingredientIdText.setVisible(false);

        this.saveIngredientButton.addActionListener(e -> {
            var quantity = BigDecimal.ZERO;
            try {
                quantity = new BigDecimal(quantityField.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.addIngredientFrame,
                        "Please input a valid number in quantity text field", "Invalid number in quantity text field",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (this.ingredientNameCombo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this.addIngredientFrame,
                        "Please input a valid number in quantity text field", "Invalid number in quantity text field",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (this.UnitCombo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this.addIngredientFrame,
                        "Please input a valid number in quantity text field", "Invalid number in quantity text field",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            var id = ((String) this.ingredientNameCombo.getSelectedItem()).split(Pattern.quote(" | "))[0]; // Chữa cháy
                                                                                                           // :<
            var name = ((String) this.ingredientNameCombo.getSelectedItem()).split(Pattern.quote(" | "))[1]; // Chữa
                                                                                                             // cháy :<
            var unit = (String) this.UnitCombo.getSelectedItem();
            var i = new Ingredient(id, name, quantity, unit, null, null);
            this.recipe.getIngredient().add(i);
            this.ingredientsTableModel
                    .addRow(new Object[] { i.getId(), name, i.getQuantity().toString(), i.getUnit(), i.getNote() });
            this.addIngredientFrame.setVisible(false);

        });

        this.ingredientNameCombo.addActionListener(e -> {
            var id = ((String) this.ingredientNameCombo.getSelectedItem()).split(" | ")[0]; // Chữa cháy :<
            var i = allIngredients.get(allIngredients.indexOf(new Ingredient(id, null, null, null, null, null)));
            this.UnitCombo.setModel(new DefaultComboBoxModel<String>(new String[] { i.getUnit() }));
        });
    }

    public static void main(String[] args) {
        final String INPUT = "Panya/src/main/resources/data/RecipeData/RecipeFile.json";
        var recipe = Recipe.readRecipeList(INPUT);

        final String INGREDIENTS = "Panya/src/main/resources/data/IngredientData/IngredientFile.json";
        var ingredients = Ingredient.readIngredients(INGREDIENTS);

        var themeName = "blue";
        var theme = new Theme().getTheme(themeName);
        var light = new ColorUIResource(theme.get("300"));
        var primary = new ColorUIResource(theme.get("500"));
        var dark = new ColorUIResource(theme.get("800"));
        SwingUtilities.invokeLater(() -> {
            var recipeWindow = new RecipeWindow(primary, light, dark, false, INGREDIENTS, null);
            recipeWindow.addNewRecipeView();
            // recipeWindow.loadRecipe(recipe.get(0));
            recipeWindow.setVisible(true);
        });
    }
}
