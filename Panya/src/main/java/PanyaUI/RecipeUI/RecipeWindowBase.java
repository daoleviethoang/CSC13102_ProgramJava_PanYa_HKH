/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PanyaUI.RecipeUI;

import javax.swing.UIManager;

import PanyaUI.PanyaContentPanel;
import PanyaUI.Theme;
import mdlaf.MaterialLookAndFeel;
import java.awt.Color;

/**
 *
 * @author dqh
 */
public class RecipeWindowBase extends javax.swing.JFrame implements PanyaContentPanel {

    /**
     *
     */
    private static final long serialVersionUID = 4207515231747115028L;
    Color primaryColor;
    Color darkColor;
    Color lightColor;
    Color primaryTextColor;
    Color lightTextColor;
    Color darkTextColor;
    boolean randomColor = false;

    /** Creates new form RecipeWindow */
    public RecipeWindowBase() {
        initComponents();
    }

    public RecipeWindowBase(Color primary, Color light, Color dark, boolean randomColor) {
        super();
        initComponents();
        this.initTheme(primary, light, dark);
        this.randomColor = randomColor;
    }

    /**
     * Chỉnh màu cho window theo phổ màu đưa vào
     * 
     * @param themeName String được lấy từ PanyaUI.Theme.getTheme
     * @see PanyaUI.Theme#getTheme(String)
     */
    public void initTheme(String themeName) {
        var theme = new Theme().getTheme(themeName);
        if (theme == null) {
            return;
        }

        final var PRIMARY = theme.get(Theme.PRIMARY);
        final var LIGHT = theme.get(Theme.LIGHT);
        final var DARK = theme.get(Theme.DARK);

        this.initTheme(PRIMARY, LIGHT, DARK);
    }
    
    /**
     * Set màu cho window theo phổ màu đưa vào. Tham số đưa vào gồm 3 loại màu:
     * chính, nhạt, đậm. Tham khảo tại <a href=
     * "https://material.io/resources/color">https://material.io/resources/color</a>
     * 
     * @param primary
     * @param light
     * @param dark
     */
    public void initTheme(Color primary, Color light, Color dark) {
        if (primary == null || light == null || dark == null) {
            return;
        }
        this.primaryColor = primary;
        this.darkColor = dark;
        this.lightColor = light;

        this.primaryTextColor = Theme.textColorFromBackgroundColor(primary);
        this.darkTextColor = Theme.textColorFromBackgroundColor(dark);
        this.lightTextColor = Theme.textColorFromBackgroundColor(light);

        // this.bottomHeaderPanel.setBackground(lightColor);
        this.contentHeaderLabel.setForeground(primaryTextColor);
        this.contentHeaderPanel.setBackground(primaryColor);
        // this.contentPanel;
        // this.outerContentPanel;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        addIngredientFrame = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        ingredientNameCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        UnitCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        saveIngredientButton = new javax.swing.JButton();
        ingredientIdText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        contentHeaderPanel = new javax.swing.JPanel();
        contentHeaderLabel = new javax.swing.JLabel();
        basicInfoPanel = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTextField = new javax.swing.JTextArea();
        ingredientsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingredientTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        addIngredientButton = new javax.swing.JButton();
        removeIngredientButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        secretRecipeCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        addIngredientFrame.setMinimumSize(new java.awt.Dimension(400, 171));
        addIngredientFrame.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Ingredient");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        addIngredientFrame.getContentPane().add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        addIngredientFrame.getContentPane().add(ingredientNameCombo, gridBagConstraints);

        jLabel2.setText("Unit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        addIngredientFrame.getContentPane().add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        addIngredientFrame.getContentPane().add(UnitCombo, gridBagConstraints);

        jLabel3.setText("Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        addIngredientFrame.getContentPane().add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        addIngredientFrame.getContentPane().add(quantityField, gridBagConstraints);

        saveIngredientButton.setText("Save");
        jPanel6.add(saveIngredientButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        addIngredientFrame.getContentPane().add(jPanel6, gridBagConstraints);

        ingredientIdText.setEditable(false);
        ingredientIdText.setText("jTextField1");
        ingredientIdText.setEnabled(false);
        addIngredientFrame.getContentPane().add(ingredientIdText, new java.awt.GridBagConstraints());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 800));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(110, 198, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(600, 200));
        jPanel4.setPreferredSize(new java.awt.Dimension(600, 200));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setText("Image");
        imageLabel.setMaximumSize(new java.awt.Dimension(600, 200));
        imageLabel.setMinimumSize(new java.awt.Dimension(600, 200));
        imageLabel.setPreferredSize(new java.awt.Dimension(600, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel4.add(imageLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel4, gridBagConstraints);

        contentHeaderPanel.setBackground(new java.awt.Color(33, 150, 243));
        contentHeaderPanel.setMinimumSize(new java.awt.Dimension(600, 50));
        contentHeaderPanel.setPreferredSize(new java.awt.Dimension(600, 50));

        contentHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contentHeaderLabel.setText("Recipe");
        contentHeaderLabel.setToolTipText("");

        javax.swing.GroupLayout contentHeaderPanelLayout = new javax.swing.GroupLayout(contentHeaderPanel);
        contentHeaderPanel.setLayout(contentHeaderPanelLayout);
        contentHeaderPanelLayout.setHorizontalGroup(
            contentHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        contentHeaderPanelLayout.setVerticalGroup(
            contentHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(contentHeaderPanel, gridBagConstraints);

        basicInfoPanel.setBackground(new java.awt.Color(33, 150, 243));
        basicInfoPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        basicInfoPanel.setMinimumSize(new java.awt.Dimension(600, 500));
        basicInfoPanel.setPreferredSize(new java.awt.Dimension(600, 500));

        jPanel3.setMinimumSize(new java.awt.Dimension(600, 500));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        nameLabel.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPanel3.add(nameLabel, gridBagConstraints);

        nameTextField.setEditable(false);
        nameTextField.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        nameTextField.setToolTipText("");
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 10);
        jPanel3.add(nameTextField, gridBagConstraints);

        descriptionLabel.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(descriptionLabel, gridBagConstraints);

        descriptionTextField.setEditable(false);
        descriptionTextField.setColumns(20);
        descriptionTextField.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        descriptionTextField.setRows(5);
        jScrollPane2.setViewportView(descriptionTextField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel3.add(jScrollPane2, gridBagConstraints);

        basicInfoPanel.addTab("Basic information", jPanel3);

        ingredientsPanel.setLayout(new java.awt.GridBagLayout());

        ingredientTable.setAutoCreateRowSorter(true);
        ingredientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Name", "Quantity", "Unit", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ingredientTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(ingredientTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        ingredientsPanel.add(jScrollPane1, gridBagConstraints);

        addIngredientButton.setText("   Add   ");
        addIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIngredientButtonActionPerformed(evt);
            }
        });
        jPanel5.add(addIngredientButton);

        removeIngredientButton.setText("Remove");
        removeIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeIngredientButtonActionPerformed(evt);
            }
        });
        jPanel5.add(removeIngredientButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        ingredientsPanel.add(jPanel5, gridBagConstraints);

        basicInfoPanel.addTab("Ingredients", ingredientsPanel);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        secretRecipeCheckBox.setText("Secret recipe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jPanel2.add(secretRecipeCheckBox, gridBagConstraints);

        basicInfoPanel.addTab("Advance", jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(basicInfoPanel, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(600, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 50));

        editButton.setText("Edit");
        editButton.setMaximumSize(new java.awt.Dimension(95, 40));
        editButton.setMinimumSize(new java.awt.Dimension(95, 40));
        editButton.setPreferredSize(new java.awt.Dimension(95, 40));
        jPanel1.add(editButton);

        saveButton.setText("Save");
        saveButton.setMaximumSize(new java.awt.Dimension(95, 40));
        saveButton.setMinimumSize(new java.awt.Dimension(95, 40));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton);

        removeButton.setText("Remove");
        removeButton.setMaximumSize(new java.awt.Dimension(95, 40));
        removeButton.setMinimumSize(new java.awt.Dimension(95, 40));
        removeButton.setPreferredSize(new java.awt.Dimension(95, 40));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(removeButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeButtonActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void removeIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeIngredientButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeIngredientButtonActionPerformed

    private void addIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredientButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addIngredientButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (Exception ignored) {
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecipeWindowBase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JComboBox<String> UnitCombo;
    javax.swing.JButton addIngredientButton;
    javax.swing.JFrame addIngredientFrame;
    javax.swing.JTabbedPane basicInfoPanel;
    javax.swing.JLabel contentHeaderLabel;
    javax.swing.JPanel contentHeaderPanel;
    javax.swing.JLabel descriptionLabel;
    javax.swing.JTextArea descriptionTextField;
    javax.swing.JButton editButton;
    javax.swing.JLabel imageLabel;
    javax.swing.JTextField ingredientIdText;
    javax.swing.JComboBox<String> ingredientNameCombo;
    javax.swing.JTable ingredientTable;
    javax.swing.JPanel ingredientsPanel;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JPanel jPanel4;
    javax.swing.JPanel jPanel5;
    javax.swing.JPanel jPanel6;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JLabel nameLabel;
    javax.swing.JTextField nameTextField;
    javax.swing.JTextField quantityField;
    javax.swing.JButton removeButton;
    javax.swing.JButton removeIngredientButton;
    javax.swing.JButton saveButton;
    javax.swing.JButton saveIngredientButton;
    javax.swing.JCheckBox secretRecipeCheckBox;
    // End of variables declaration//GEN-END:variables

}
