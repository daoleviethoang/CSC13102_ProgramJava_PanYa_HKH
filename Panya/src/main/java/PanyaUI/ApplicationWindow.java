package PanyaUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Khung cửa sổ chính của ứng dụng Pan-ya. Kế thừa từ
 * <code>ApplicationWindowBase</code> là JFrame được tạo từ form của netbeans.
 * <code>ApplicationWindow</code> sẽ định nghĩa các action trên window, cũng như
 * các chức năng chính của Pan-ya
 */
public class ApplicationWindow extends ApplicationWindowBase {

    Color primaryColor;
    Color darkColor;
    Color lightColor;
    Color primaryTextColor;
    Color lightTextColor;
    Color darkTextColor;

    GridBagConstraints hideMenuHeaderPanelConstraint;
    GridBagConstraints hideMenuContentPanelConstraint;
    GridBagConstraints showMenuHeaderPanelConstraint;
    GridBagConstraints showMenuContentPanelConstraint;

    final List<JLabel> menuListLabels = new ArrayList<JLabel>() {
        {
            add(homeLabel);
            add(storageLabel);
            add(recipeLabel);
            add(menuLabel);
        }
    };

    boolean randomColor = false;

    private void initComponents() {
        this.menuIconLabel2.setVisible(false);
        this.initAction();
        this.initGridBagConstraints();
    }

    public ApplicationWindow(String themeName) {
        super();
        initComponents();
        var theme = new Theme().getTheme(themeName);
        final var PRIMARY = theme.get(Theme.PRIMARY);
        final var LIGHT = theme.get(Theme.LIGHT);
        final var DARK = theme.get(Theme.DARK);

        this.initTheme(PRIMARY, LIGHT, DARK);
        this.highlightLabelColor(homeLabel);

    }

    public ApplicationWindow(boolean randomColor) {
        super();
        initComponents();
        var theme = new Theme().getTheme(Theme.getRandomThemeName());
        var PRIMARY = theme.get(Theme.PRIMARY);
        var LIGHT = theme.get(Theme.LIGHT);
        var DARK = theme.get(Theme.DARK);
        this.randomColor = randomColor;
        this.initTheme(PRIMARY, LIGHT, DARK);
        this.highlightLabelColor(homeLabel);

    }

    public ApplicationWindow(Color primary, Color light, Color dark, boolean randomColor) {
        super();
        initComponents();
        this.initTheme(primary, light, dark);
        this.highlightLabelColor(homeLabel);
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

        this.bottomHeaderPanel.setBackground(lightColor);
        this.contentHeaderLabel.setForeground(primaryTextColor);
        this.contentHeaderPanel.setBackground(primaryColor);
        // this.contentPanel;
        // this.headerPanel;
        this.homeLabel.setBackground(primaryTextColor);
        this.imageLabel.setBackground(primaryTextColor);
        this.imagePanel.setBackground(primaryColor);

        if (darkTextColor.equals(Color.BLACK)) {
            this.menuIconLabel.setIcon(new ImageIcon(getClass().getResource("/images/baseline_menu_black_18dp.png")));
        }
        this.menuLabel.setForeground(lightTextColor);
        this.menuListPanel.setBackground(lightColor);
        this.menuPanel.setBackground(lightColor);
        this.recipeLabel.setForeground(lightTextColor);
        this.storageLabel.setBackground(lightColor);
        this.storageLabel.setForeground(lightTextColor);
        this.titlePanel.setBackground(darkColor);
        this.topHeaderLabel.setForeground(darkTextColor);
        this.topHeaderPanel.setBackground(darkColor);

        this.highlightLabelColor(this.homeLabel);
        this.defaultLabelColor(this.storageLabel);
    }

    private void initAction() {
        menuListLabels.forEach(lbl -> lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                highlightLabel(lbl);
            }
        }));
        this.menuIconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showMenuActionPerformed();
            }
        });
        this.menuIconLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showMenuActionPerformed();
            }
        });
    }

    private void initGridBagConstraints() {
        var layout = (GridBagLayout) this.getContentPane().getLayout();
        showMenuContentPanelConstraint = layout.getConstraints(this.contentPanel);
        showMenuHeaderPanelConstraint = layout.getConstraints(this.headerPanel);

        hideMenuContentPanelConstraint = new java.awt.GridBagConstraints();
        hideMenuContentPanelConstraint.gridx = 0;
        hideMenuContentPanelConstraint.gridy = 1;
        hideMenuContentPanelConstraint.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        hideMenuContentPanelConstraint.gridheight = java.awt.GridBagConstraints.REMAINDER;
        hideMenuContentPanelConstraint.fill = java.awt.GridBagConstraints.BOTH;
        hideMenuContentPanelConstraint.weightx = 0.1;
        hideMenuContentPanelConstraint.weighty = 0.1;

        hideMenuHeaderPanelConstraint = new java.awt.GridBagConstraints();
        hideMenuHeaderPanelConstraint.gridx = 0;
        hideMenuHeaderPanelConstraint.gridy = 0;
        hideMenuHeaderPanelConstraint.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        hideMenuHeaderPanelConstraint.fill = java.awt.GridBagConstraints.BOTH;
        hideMenuHeaderPanelConstraint.weightx = 0.1;
    }

    private void highlightLabel(JLabel lbl) {
        for (var jLabel : menuListLabels) {
            if (jLabel == lbl) {
                highlightLabelColor(lbl);
            } else {
                defaultLabelColor(jLabel);
            }
        }
    }

    private void highlightLabelColor(JLabel lbl) {
        lbl.setOpaque(true);
        lbl.setBackground(primaryColor);
        lbl.setForeground(primaryTextColor);
    }

    private void defaultLabelColor(JLabel lbl) {
        lbl.setOpaque(true);
        lbl.setBackground(lightColor);
        lbl.setForeground(lightTextColor);
    }

    private void showMenuActionPerformed(){
        var layout = (GridBagLayout) this.getContentPane().getLayout();

        if (this.menuPanel.isVisible()){
            this.menuPanel.setVisible(false);
            this.menuIconLabel2.setVisible(true);
            layout.setConstraints(this.headerPanel, this.hideMenuHeaderPanelConstraint);
            layout.setConstraints(this.contentPanel, this.hideMenuContentPanelConstraint);
        }
        else {
            this.menuPanel.setVisible(true);
            this.menuIconLabel2.setVisible(false);
            layout.setConstraints(this.contentPanel, this.showMenuContentPanelConstraint);
            layout.setConstraints(this.headerPanel, this.showMenuHeaderPanelConstraint);
        }
        this.validate();
        this.repaint();
    }

}