package PanyaUI.RecipeUI;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import PanyaCore.Recipe;
import java.awt.Color;

public class RecipeMainPanel extends RecipeMainPanelBase {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    String recipeFile;
    List<Recipe> recipes;
    DefaultTableModel recipeModel;
    DefaultTableModel secretRecipeModel;
    RecipeWindow recipeWindow;

    String ingredientFile = "Panya/src/main/resources/data/IngredientData/IngredientFile.json";

    public RecipeMainPanel(String recipeFile) throws FileNotFoundException {
        super();

        if (!new File(recipeFile).exists()) {
            throw new FileNotFoundException(recipeFile);
        }

        this.recipeFile = recipeFile;
        this.recipes = Recipe.readRecipeList(recipeFile);
        initComponents();
        initTable();
        initAction();
    }

    void initTable() {
        // Hack: trong Netbeans để 4 dòng table trống, xóa nó đi để load data thật
        for (int i = 0; i < 4; i++) {
            this.recipeModel.removeRow(0);
            this.secretRecipeModel.removeRow(0);
        }

        for (var recipe : recipes) {
            var rowData = new Object[] { recipe.getId() , recipe.getName(), recipe.getNote() };
            this.recipeModel.addRow(rowData);
        }
    }

    public void initTheme(Color primary, Color light, Color dark) {
        super.initTheme(primary, light, dark);
        this.recipeWindow.initTheme(primary, light, dark);
    }

    void initComponents() {
        this.recipeModel = (DefaultTableModel) this.recipeTable.getModel();
        this.secretRecipeModel = (DefaultTableModel) this.secretRecipeTable.getModel();
        this.recipeWindow = new RecipeWindow(this.primaryColor, this.lightColor, this.darkColor, false,
                ingredientFile, this);
        this.recipeWindow.setVisible(false);
    }

    void initAction() {
        super.initAction();
        this.addRecipeButton.addActionListener(e -> {
            this.recipeWindow.setVisible(true);
            this.recipeWindow.addNewRecipeView();
        });

        this.recipeTable.addMouseListener(new MouseInputAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    var row = recipeTable.getSelectedRow();
                    if (row != -1) {
                        var r = recipes.get(row);
                        recipeWindow.viewAndEditRecipeView(r);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        final String recipeFile = "Panya/src/main/resources/data/RecipeData/RecipeFile-out.json";
        // var recipes = Recipe.readRecipeList(INPUT);
        SwingUtilities.invokeLater(() -> {
            try {
                new RecipeMainPanel(recipeFile).setVisible(true);

            } catch (Exception e) {
                // TODO: handle exception
            }

        });

    }
}
