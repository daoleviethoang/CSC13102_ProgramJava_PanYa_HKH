/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanyaUI.ManageUI.HistoryUI;

import PanyaUI.PanyaContentPanel;
import PanyaUI.Theme;
import java.awt.Color;
/**
 *
 * @author Dao Le Viet Hoang
 */
public class HistoryWindow extends javax.swing.JPanel implements PanyaContentPanel {

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

    }

    /**
     * Creates new form OuterContentPanel
     */
    public HistoryWindow() {
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
        contentPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bottomHeaderPanel = new javax.swing.JPanel();
        addButon = new javax.swing.JButton();
        deleteButon = new javax.swing.JButton();
        updataButon = new javax.swing.JButton();
        saleOffButon = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchButon = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(600, 600));
        setLayout(new java.awt.GridBagLayout());

        contentHeaderPanel.setBackground(new java.awt.Color(33, 150, 243));
        contentHeaderPanel.setMinimumSize(new java.awt.Dimension(600, 100));

        contentHeaderLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        contentHeaderLabel.setForeground(new java.awt.Color(255, 255, 255));
        contentHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contentHeaderLabel.setText("HISTORY");

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

        contentPanel.setBackground(java.awt.Color.white);
        contentPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        contentPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "ID", "Quantity", "Sell Off", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(contentPanel, gridBagConstraints);

        bottomHeaderPanel.setBackground(new java.awt.Color(110, 198, 255));
        bottomHeaderPanel.setMinimumSize(new java.awt.Dimension(600, 50));

        addButon.setBackground(new java.awt.Color(0, 153, 102));
        addButon.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        addButon.setForeground(new java.awt.Color(255, 255, 255));
        addButon.setText("Add");
        addButon.setBorder(null);

        deleteButon.setBackground(new java.awt.Color(0, 153, 102));
        deleteButon.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        deleteButon.setForeground(new java.awt.Color(255, 255, 255));
        deleteButon.setText("Delete");
        deleteButon.setBorder(null);

        updataButon.setBackground(new java.awt.Color(0, 153, 102));
        updataButon.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        updataButon.setForeground(new java.awt.Color(255, 255, 255));
        updataButon.setText("Update");
        updataButon.setBorder(null);

        saleOffButon.setBackground(new java.awt.Color(255, 153, 0));
        saleOffButon.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        saleOffButon.setForeground(new java.awt.Color(255, 255, 255));
        saleOffButon.setText("Statistic");
        saleOffButon.setBorder(null);

        searchPanel.setPreferredSize(new java.awt.Dimension(160, 40));

        searchButon.setBackground(new java.awt.Color(0, 153, 102));
        searchButon.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        searchButon.setForeground(new java.awt.Color(255, 255, 255));
        searchButon.setText("Search");
        searchButon.setBorder(null);
        searchButon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButonActionPerformed(evt);
            }
        });

        searchTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchTextField.setToolTipText("");
        searchTextField.setAutoscrolls(false);
        searchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 2));
        searchTextField.setDoubleBuffered(true);
        searchTextField.setDragEnabled(true);
        searchTextField.setMaximumSize(new java.awt.Dimension(32767, 32767));
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(searchButon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bottomHeaderPanelLayout = new javax.swing.GroupLayout(bottomHeaderPanel);
        bottomHeaderPanel.setLayout(bottomHeaderPanelLayout);
        bottomHeaderPanelLayout.setHorizontalGroup(
            bottomHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomHeaderPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(addButon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(deleteButon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(updataButon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(saleOffButon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        bottomHeaderPanelLayout.setVerticalGroup(
            bottomHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomHeaderPanelLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(bottomHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(saleOffButon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bottomHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteButon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updataButon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(bottomHeaderPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButon;
    private javax.swing.JPanel bottomHeaderPanel;
    private javax.swing.JLabel contentHeaderLabel;
    private javax.swing.JPanel contentHeaderPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteButon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton saleOffButon;
    private javax.swing.JButton searchButon;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton updataButon;
    // End of variables declaration//GEN-END:variables
}
