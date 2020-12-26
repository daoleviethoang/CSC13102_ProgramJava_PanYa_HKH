/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanyaUI;
import PanyaUI.Theme;
import java.awt.Color;
/**
 *
 * @author Dao Le Viet Hoang
 */
public class ManageWindow extends javax.swing.JPanel implements PanyaContentPanel {

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
    public ManageWindow() {
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
        jLabel1 = new javax.swing.JLabel();
        bottomHeaderPanel = new javax.swing.JPanel();
        addButon = new javax.swing.JButton();
        deleteButon = new javax.swing.JButton();
        updataButon = new javax.swing.JButton();

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
            .addComponent(contentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
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

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EFFECT");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
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
        addButon.setText("MENU");
        addButon.setBorder(null);

        deleteButon.setBackground(new java.awt.Color(0, 153, 102));
        deleteButon.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        deleteButon.setForeground(new java.awt.Color(255, 255, 255));
        deleteButon.setText("HISTORY");
        deleteButon.setBorder(null);
        deleteButon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        updataButon.setBackground(new java.awt.Color(0, 153, 102));
        updataButon.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        updataButon.setForeground(new java.awt.Color(255, 255, 255));
        updataButon.setText("CUSTOMER ORDER");
        updataButon.setBorder(null);
        updataButon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout bottomHeaderPanelLayout = new javax.swing.GroupLayout(bottomHeaderPanel);
        bottomHeaderPanel.setLayout(bottomHeaderPanelLayout);
        bottomHeaderPanelLayout.setHorizontalGroup(
            bottomHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomHeaderPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(addButon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(deleteButon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(updataButon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        bottomHeaderPanelLayout.setVerticalGroup(
            bottomHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updataButon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButon;
    private javax.swing.JPanel bottomHeaderPanel;
    private javax.swing.JLabel contentHeaderLabel;
    private javax.swing.JPanel contentHeaderPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton updataButon;
    // End of variables declaration//GEN-END:variables
}
