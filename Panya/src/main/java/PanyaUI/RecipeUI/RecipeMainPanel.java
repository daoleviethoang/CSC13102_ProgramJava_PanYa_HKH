package PanyaUI.RecipeUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import PanyaCore.Recipe;

public class RecipeMainPanel extends RecipeMainPanelBase {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    String recipeFile;
    List<Recipe> recipes;
    DefaultTableModel recipeModel;
    DefaultTableModel secretRecipeModel;
    RecipeWindowBase recipeWindow;

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
        int no = 1;
        // Hack: trong Netbeans để 4 dòng table trống, xóa nó đi để load data thật 
        for (int i = 0; i < 4; i++) {
            this.recipeModel.removeRow(0);
            this.secretRecipeModel.removeRow(0);
        }

        for (var recipe : recipes) {
            var rowData = new Object[]{no, recipe.getName(), recipe.getNote()};
            this.recipeModel.addRow(rowData);
        }
    }

    void initComponents(){
        this.recipeModel = (DefaultTableModel) this.recipeTable.getModel();
        this.secretRecipeModel = (DefaultTableModel) this.secretRecipeTable.getModel();
        this.recipeWindow = new RecipeWindowBase(this.primaryColor, this.lightColor, this.darkColor, false);
        this.recipeWindow.setVisible(false);
    }

    void initAction() {
        super.initAction();
        this.addRecipeButton.addActionListener(
            e->{
                this.recipeWindow.setVisible(true);
            }
        );
    }

    public static void main(String[] args) {
        final String recipeFile = "Panya/src/main/resources/data/RecipeData/RecipeFile-out.json";
        // var recipes = Recipe.readRecipeList(INPUT);
        SwingUtilities.invokeLater(()->{
            try {
                new RecipeMainPanel(recipeFile).setVisible(true);

            } catch (Exception e) {
                //TODO: handle exception
            }

        });
       
    }
}

