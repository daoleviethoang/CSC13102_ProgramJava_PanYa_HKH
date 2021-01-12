/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanyaUI.HomeUI;

import java.awt.Color;

import PanyaUI.PanyaContentPanel;
import PanyaUI.Theme;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author dqh
 */
public class HomePanelBase extends javax.swing.JPanel implements PanyaContentPanel {

    /**
     *
     */
    private static final long serialVersionUID = -8660300770576249499L;
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
        this.themeLabel.setForeground(lightTextColor);
        // this.contentPanel;
        // this.outerContentPanel;

    }

    /**
     * Creates new form OuterContentPanel
     */
    public HomePanelBase() {
        initComponents();
    }

    public HomePanelBase(Color primary, Color light, Color dark) {
        initComponents();
        this.initTheme(primary, light, dark);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        contentHeaderPanel = new JPanel();
        contentHeaderLabel = new JLabel();
        bottomHeaderPanel = new JPanel();
        themeLabel = new JLabel();
        themeCombo = new JComboBox<>();
        contentPanel = new JPanel();

        setMinimumSize(new Dimension(600, 600));
        setLayout(new GridBagLayout());

        contentHeaderPanel.setBackground(new Color(33, 150, 243));
        contentHeaderPanel.setMinimumSize(new Dimension(600, 100));

        contentHeaderLabel.setText("<html>Một ứng dụng quản lý tiệm bánh giúp chủ tiệm bánh có thể kiểm kê hàng hóa, nguyên liệu, công thức làm bánh, bán bánh trong cửa hàng của mình.</html>");

        GroupLayout contentHeaderPanelLayout = new GroupLayout(contentHeaderPanel);
        contentHeaderPanel.setLayout(contentHeaderPanelLayout);
        contentHeaderPanelLayout.setHorizontalGroup(contentHeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(contentHeaderLabel, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        contentHeaderPanelLayout.setVerticalGroup(contentHeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(contentHeaderLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        add(contentHeaderPanel, gridBagConstraints);

        bottomHeaderPanel.setBackground(new Color(110, 198, 255));
        bottomHeaderPanel.setMinimumSize(new Dimension(600, 50));
        bottomHeaderPanel.setPreferredSize(new Dimension(600, 50));
        bottomHeaderPanel.setLayout(new GridBagLayout());

        themeLabel.setText("Current theme");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(0, 11, 0, 11);
        bottomHeaderPanel.add(themeLabel, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new Insets(0, 15, 0, 15);
        bottomHeaderPanel.add(themeCombo, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(bottomHeaderPanel, gridBagConstraints);

        contentPanel.setBackground(Color.white);
        contentPanel.setMinimumSize(new Dimension(600, 400));
        contentPanel.setPreferredSize(new Dimension(600, 400));
        contentPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(contentPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    javax.swing.JComboBox<String> getThemeCombo() {
        return themeCombo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    JPanel bottomHeaderPanel;
    JLabel contentHeaderLabel;
    JPanel contentHeaderPanel;
    JPanel contentPanel;
    JComboBox<String> themeCombo;
    JLabel themeLabel;
    // End of variables declaration//GEN-END:variables
}
