package PanyaUI.RecipeUI;

import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultRowSorter;
import javax.swing.JLabel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

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
    ArrayList<String> passwords = new ArrayList<>();

    String passwordFile = "Panya/src/main/resources/data/RecipeData/Password.txt";
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
        this.recipeTable.getTableHeader().setResizingAllowed(true);
    }

    void initTable() {

        this.recipeTable.getColumnModel().getColumn(0).setMinWidth(80);
        this.recipeTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.recipeTable.getColumnModel().getColumn(0).setMaxWidth(80);

        this.secretRecipeTable.getColumnModel().getColumn(0).setMinWidth(80);
        this.secretRecipeTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.secretRecipeTable.getColumnModel().getColumn(0).setMaxWidth(80);

        for (var recipe : recipes) {
            var rowData = new Object[] { recipe.getId(), recipe.getName(), recipe.getNote() };
            if (recipe.getVisibility()) {
                this.recipeModel.addRow(rowData);
            } else {
                this.secretRecipeModel.addRow(rowData);
            }
        }
    }

    public void reloadTableModels() {
        while (this.recipeModel.getRowCount() != 0) {
            this.recipeModel.removeRow(0);
        }
        while (this.secretRecipeModel.getRowCount() != 0) {
            this.secretRecipeModel.removeRow(0);
        }
        for (var recipe : recipes) {
            var rowData = new Object[] { recipe.getId(), recipe.getName(), recipe.getNote() };
            if (recipe.getVisibility()) {
                this.recipeModel.addRow(rowData);
            } else {
                this.secretRecipeModel.addRow(rowData);
            }
        }
    }

    public void initTheme(Color primary, Color light, Color dark) {
        super.initTheme(primary, light, dark);
        this.recipeWindow.initTheme(primary, light, dark);
    }

    void initComponents() {
        this.recipeModel = (DefaultTableModel) this.recipeTable.getModel();
        this.secretRecipeModel = (DefaultTableModel) this.secretRecipeTable.getModel();
        this.recipeWindow = new RecipeWindow(this.primaryColor, this.lightColor, this.darkColor, false, ingredientFile,
                this);
        this.recipeWindow.setVisible(false);
    }

    public void readPassword(String path) {
        try {
            File myObj = new File(path);
            if (!myObj.exists()) {
                try (var fin = new FileWriter(myObj)) {

                } catch (Exception e) {

                }
                this.passwords = new ArrayList<>();
                return;
            }
            try (Scanner myReader = new Scanner(myObj);) {
                // while (myReader.hasNextLine()) {
                if (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (data != null) {
                        this.passwords.add(data);
                    }
                } else {
                    this.passwords = new ArrayList<>();
                }
                // }
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void initAction() {
        this.publicLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                publicLabel.setForeground(primaryTextColor);
                publicLabel.setBackground(primaryColor);
                privateLabel.setForeground(lightTextColor);
                privateLabel.setBackground(lightColor);
                publicLabel.setVisible(true);
                privatePanel.setVisible(false);
            }
        });

        this.secretClearButton.addActionListener(e -> {
            this.secretSearchTextField.setText("");
        });

        this.clearButton.addActionListener(e -> {
            this.searchTextField.setText("");
        });

        this.privateLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionForSecretPanel();
            }
        });

        this.addRecipeButton.addActionListener(e -> {
            this.recipeWindow.setVisible(true);
            this.recipeWindow.addNewRecipeView();
        });

        this.addSecretRecipeButton.addActionListener(e -> {
            this.recipeWindow.setVisible(true);
            this.recipeWindow.addNewSecretRecipeView();
        });

        this.recipeTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    var row = recipeTable.getSelectedRow();
                    if (row != -1) {
                        var id = (String) recipeTable.getValueAt(row, 0);
                        var r = recipes.get(recipes.indexOf(new Recipe(id)));
                        recipeWindow.viewAndEditRecipeView(r);
                    }
                }
            }
        });

        this.secretRecipeTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    var row = secretRecipeTable.getSelectedRow();
                    if (row != -1) {
                        var id = (String) secretRecipeTable.getValueAt(row, 0);
                        var r = recipes.get(recipes.indexOf(new Recipe(id)));
                        recipeWindow.viewAndEditRecipeView(r);
                    }
                }
            }
        });

        this.searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                recipeTableFilter();
            }

            public void insertUpdate(DocumentEvent e) {
                recipeTableFilter();
            }

            public void removeUpdate(DocumentEvent e) {
                recipeTableFilter();
            }
        });

        this.secretSearchTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                secretRecipeTableFilter();
            }

            public void insertUpdate(DocumentEvent e) {
                secretRecipeTableFilter();
            }

            public void removeUpdate(DocumentEvent e) {
                secretRecipeTableFilter();
            }
        });
    }

    private void actionForSecretPanel() {
        boolean op = false;
        readPassword(passwordFile);

        if (passwords.isEmpty()) {
            String user_password = JOptionPane.showInputDialog(this, "Register your password", "Secret password",
                    JOptionPane.QUESTION_MESSAGE);
            passwords.add(user_password); // add vào list password

            if (user_password != null) {
                passwords.add(user_password);
                try (var fout = new FileWriter(passwordFile)) {
                    fout.write(passwords.get(0));
                } catch (Exception ex) {
                    // TODO: handle exception
                }

                publicLabel.setForeground(lightTextColor);
                publicLabel.setBackground(lightColor);
                privateLabel.setForeground(primaryTextColor);
                privateLabel.setBackground(primaryColor);
                privatePanel.setVisible(true);
                publicPanel.setVisible(false);
            }

            op = true;
        }

        while (op == false) {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Enter a password:");
            JPasswordField p = new JPasswordField(10);
            panel.add(label);
            panel.add(p);
            String[] secretOptions = new String[] { "OK", "Cancel" };
            int option = JOptionPane.showOptionDialog(null, panel, "Secret password", JOptionPane.NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, secretOptions, secretOptions[1]);
            boolean auth = false;
            if (option == 0) {
                // pressing OK button
                var user_password = new String(p.getPassword());
                if (user_password != null) {
                    for (String pass : passwords) {
                        if (user_password.compareTo(pass) == 0) {
                            auth = true;
                        }
                    }
                }
            }

            if (auth) {
                op = true;
                publicLabel.setForeground(lightTextColor);
                publicLabel.setBackground(lightColor);
                privateLabel.setForeground(primaryTextColor);
                privateLabel.setBackground(primaryColor);
                privatePanel.setVisible(true);
                publicPanel.setVisible(false);
            } else { // nếu sai thì cho chọn dk password hoặc nhập lại
                Object[] options = { "Yes, please", "No, thanks" };
                int n = JOptionPane.showOptionDialog(this,
                        "Your password is incorrect, do you want to input this password again\n", "Validation failed",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (n == 0) { // nhập lại
                    op = false;
                } else { //
                    return;
                }
            }
        }
    }

    /**
     * Update the row filter regular expression from the expression in the text box.
     */
    private void recipeTableFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        // If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter("(?i)" + this.searchTextField.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        ((DefaultRowSorter<DefaultTableModel, Object>) this.recipeTable.getRowSorter()).setRowFilter(rf);
    }

    private void secretRecipeTableFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        // If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter("(?i)" + this.secretSearchTextField.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        ((DefaultRowSorter<DefaultTableModel, Object>) this.secretRecipeTable.getRowSorter()).setRowFilter(rf);
    }

    // public static void main(String[] args) {
    // final String recipeFile =
    // "Panya/src/main/resources/data/RecipeData/RecipeFile-out.json";
    // // var recipes = Recipe.readRecipeList(INPUT);
    // SwingUtilities.invokeLater(() -> {
    // try {
    // new RecipeMainPanel(recipeFile).setVisible(true);

    // } catch (Exception e) {
    // // TODO: handle exception
    // }

    // });

    // }
}
