/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanyaUI.RecipeUI;

import PanyaUI.PanyaContentPanel;
import PanyaUI.Theme;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author dqh
 */
public class RecipeMainPanel extends javax.swing.JPanel implements PanyaContentPanel {

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
        // this.contentPanel;
        // this.outerContentPanel;

        this.publicLabel.setForeground(primaryTextColor);
        this.publicLabel.setBackground(primaryColor);
        this.privateLabel.setForeground(lightTextColor);
        this.privateLabel.setBackground(lightColor);

    }
    void initAction() {
        this.publicLabel.addMouseListener(new MouseAdapter(){
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
        var frame = this;

        this.privateLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                var pass = JOptionPane.showInputDialog(frame, "Input your password");
                if (true){
                    // TODO: password validation
                    publicLabel.setForeground(lightTextColor);
                    publicLabel.setBackground(lightColor);
                    privateLabel.setForeground(primaryTextColor);
                    privateLabel.setBackground(primaryColor);
                    privatePanel.setVisible(true);
                    publicPanel.setVisible(false);
                }
            }
        });
    }
    /**
     * Creates new form OuterContentPanel
     */
    public RecipeMainPanel() {
        initComponents();
        initAction();
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
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        privatePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

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

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setMinimumSize(new java.awt.Dimension(450, 39));
        jTextField1.setPreferredSize(new java.awt.Dimension(450, 39));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 16);
        jPanel2.add(jTextField1, gridBagConstraints);

        jButton4.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel2.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 10, 0);
        publicPanel.add(jPanel2, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(25);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        publicPanel.add(jScrollPane1, gridBagConstraints);

        jButton1.setText("Add new recipe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        publicPanel.add(jButton1, gridBagConstraints);

        contentPanel.add(publicPanel, "card2");

        privatePanel.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setMinimumSize(new java.awt.Dimension(450, 39));
        jTextField2.setPreferredSize(new java.awt.Dimension(450, 39));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 16);
        jPanel3.add(jTextField2, gridBagConstraints);

        jButton5.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel3.add(jButton5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 10, 0);
        privatePanel.add(jPanel3, gridBagConstraints);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(25);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        privatePanel.add(jScrollPane2, gridBagConstraints);

        jButton2.setText("Add new Secret recipe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        privatePanel.add(jButton2, gridBagConstraints);

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
    private javax.swing.JPanel bottomHeaderPanel;
    private javax.swing.JLabel contentHeaderLabel;
    private javax.swing.JPanel contentHeaderPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel privateLabel;
    private javax.swing.JPanel privatePanel;
    private javax.swing.JLabel publicLabel;
    private javax.swing.JPanel publicPanel;
    // End of variables declaration//GEN-END:variables
}
