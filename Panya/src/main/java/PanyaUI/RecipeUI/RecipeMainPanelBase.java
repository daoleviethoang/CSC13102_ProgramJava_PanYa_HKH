/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanyaUI.RecipeUI;

import PanyaUI.PanyaContentPanel;
import PanyaUI.Theme;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author dqh
 */
public class RecipeMainPanelBase extends javax.swing.JPanel implements PanyaContentPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Color primaryColor;
    Color darkColor;
    Color lightColor;
    Color primaryTextColor;
    Color lightTextColor;
    Color darkTextColor;

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

        this.bottomHeaderPanel.setBackground(lightColor);
        this.contentHeaderLabel.setForeground(primaryTextColor);
        this.contentHeaderPanel.setBackground(primaryColor);

        this.publicLabel.setForeground(primaryTextColor);
        this.publicLabel.setBackground(primaryColor);
        this.privateLabel.setForeground(lightTextColor);
        this.privateLabel.setBackground(lightColor);

        var primaryResource = new ColorUIResource(primary);
        var darkResource = new ColorUIResource(dark);
    
        var textColor = new ColorUIResource(Theme.textColorFromBackgroundColor(dark));
        UIManager.put("Button.background", primaryResource);
        UIManager.put("Button.mouseHoverColor", darkResource);
        UIManager.put("Button.foreground", textColor);

    }

    /**
     * Creates new form OuterContentPanel
     */
    public RecipeMainPanelBase() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        contentHeaderPanel = new javax.swing.JPanel();
        contentHeaderLabel = new javax.swing.JLabel();
        bottomHeaderPanel = new javax.swing.JPanel();
        publicLabel = new javax.swing.JLabel();
        privateLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        publicPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeTable = new javax.swing.JTable();
        addRecipeButton = new javax.swing.JButton();
        privatePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        secretSearchTextField = new javax.swing.JTextField();
        secretSearchButton = new javax.swing.JButton();
        secretClearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        secretRecipeTable = new javax.swing.JTable();
        addSecretRecipeButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(600, 600));
        setLayout(new java.awt.GridBagLayout());

        contentHeaderPanel.setBackground(new java.awt.Color(33, 150, 243));
        contentHeaderPanel.setMinimumSize(new java.awt.Dimension(600, 100));

        contentHeaderLabel.setText("Main Recipe");

        javax.swing.GroupLayout contentHeaderPanelLayout = new javax.swing.GroupLayout(contentHeaderPanel);
        contentHeaderPanel.setLayout(contentHeaderPanelLayout);
        contentHeaderPanelLayout.setHorizontalGroup(
            contentHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        contentHeaderPanelLayout.setVerticalGroup(
            contentHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        add(contentHeaderPanel, gridBagConstraints);

        bottomHeaderPanel.setBackground(new java.awt.Color(110, 198, 255));
        bottomHeaderPanel.setMinimumSize(new java.awt.Dimension(600, 50));
        bottomHeaderPanel.setPreferredSize(new java.awt.Dimension(600, 50));
        bottomHeaderPanel.setLayout(new java.awt.GridBagLayout());

        publicLabel.setBackground(new java.awt.Color(33, 150, 243));
        publicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        publicLabel.setText("Public");
        publicLabel.setMaximumSize(new java.awt.Dimension(300, 50));
        publicLabel.setMinimumSize(new java.awt.Dimension(300, 50));
        publicLabel.setOpaque(true);
        publicLabel.setPreferredSize(new java.awt.Dimension(300, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        bottomHeaderPanel.add(publicLabel, gridBagConstraints);

        privateLabel.setBackground(new java.awt.Color(110, 198, 255));
        privateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        privateLabel.setText("Private");
        privateLabel.setMaximumSize(new java.awt.Dimension(300, 50));
        privateLabel.setMinimumSize(new java.awt.Dimension(300, 50));
        privateLabel.setOpaque(true);
        privateLabel.setPreferredSize(new java.awt.Dimension(300, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        bottomHeaderPanel.add(privateLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(bottomHeaderPanel, gridBagConstraints);

        contentPanel.setBackground(java.awt.Color.white);
        contentPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        contentPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        contentPanel.setLayout(new java.awt.CardLayout());

        publicPanel.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        searchTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchTextField.setMinimumSize(new java.awt.Dimension(450, 39));
        searchTextField.setPreferredSize(new java.awt.Dimension(450, 39));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 16);
        jPanel2.add(searchTextField, gridBagConstraints);

        searchButton.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel2.add(searchButton, gridBagConstraints);

        clearButton.setText(" Clear ");
        clearButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel2.add(clearButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 10, 0);
        publicPanel.add(jPanel2, gridBagConstraints);

        recipeTable.setAutoCreateRowSorter(true);
        recipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Name", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recipeTable.setToolTipText("Double click to a recipe to see the details");
        recipeTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(recipeTable);
        if (recipeTable.getColumnModel().getColumnCount() > 0) {
            recipeTable.getColumnModel().getColumn(0).setMinWidth(25);
            recipeTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            recipeTable.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        publicPanel.add(jScrollPane1, gridBagConstraints);

        addRecipeButton.setText("Add new recipe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        publicPanel.add(addRecipeButton, gridBagConstraints);

        contentPanel.add(publicPanel, "card2");

        privatePanel.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        secretSearchTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        secretSearchTextField.setMinimumSize(new java.awt.Dimension(450, 39));
        secretSearchTextField.setPreferredSize(new java.awt.Dimension(450, 39));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 16);
        jPanel3.add(secretSearchTextField, gridBagConstraints);

        secretSearchButton.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel3.add(secretSearchButton, gridBagConstraints);

        secretClearButton.setText("Clear");
        secretClearButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel3.add(secretClearButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 10, 0);
        privatePanel.add(jPanel3, gridBagConstraints);

        secretRecipeTable.setAutoCreateRowSorter(true);
        secretRecipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Name", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        secretRecipeTable.setToolTipText("Double click to a recipe to see the details");
        jScrollPane2.setViewportView(secretRecipeTable);
        if (secretRecipeTable.getColumnModel().getColumnCount() > 0) {
            secretRecipeTable.getColumnModel().getColumn(0).setMinWidth(25);
            secretRecipeTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            secretRecipeTable.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        privatePanel.add(jScrollPane2, gridBagConstraints);

        addSecretRecipeButton.setText("Add new Secret recipe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        privatePanel.add(addSecretRecipeButton, gridBagConstraints);

        contentPanel.add(privatePanel, "card3");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(contentPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton addRecipeButton;
    javax.swing.JButton addSecretRecipeButton;
    javax.swing.JPanel bottomHeaderPanel;
    javax.swing.JButton clearButton;
    javax.swing.JLabel contentHeaderLabel;
    javax.swing.JPanel contentHeaderPanel;
    javax.swing.JPanel contentPanel;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JLabel privateLabel;
    javax.swing.JPanel privatePanel;
    javax.swing.JLabel publicLabel;
    javax.swing.JPanel publicPanel;
    javax.swing.JTable recipeTable;
    javax.swing.JButton searchButton;
    javax.swing.JTextField searchTextField;
    javax.swing.JButton secretClearButton;
    javax.swing.JTable secretRecipeTable;
    javax.swing.JButton secretSearchButton;
    javax.swing.JTextField secretSearchTextField;
    // End of variables declaration//GEN-END:variables
}
