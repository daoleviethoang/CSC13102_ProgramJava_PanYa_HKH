package PanyaUI;

import javax.swing.*;

import PanyaUI.ManageUI.ManageWindow;
import PanyaUI.RecipeUI.RecipeMainPanel;
import PanyaUI.RecipeUI.RecipeMainPanelBase;
import PanyaUI.StorageUI.StorageWindow;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import PanyaCore.Product;
import PanyaCore.Menu;

/**
 * Khung cửa sổ chính của ứng dụng Pan-ya. Kế thừa từ
 * <code>ApplicationWindowBase</code> là JFrame được tạo từ form của netbeans.
 * <code>ApplicationWindow</code> sẽ định nghĩa các action trên window, cũng như
 * các chức năng chính của Pan-ya
 */
public class ApplicationWindow extends ApplicationWindowBase {
    private static List<Menu> menu = new ArrayList<Menu>();
    private static List<Product> products = new ArrayList<Product>();

    Color primaryColor;
    Color darkColor;
    Color lightColor;
    Color primaryTextColor;
    Color lightTextColor;
    Color darkTextColor;
    Font hightlightFont;
    Font unhilightFont;

    GridBagConstraints hideMenuHeaderPanelConstraint;
    GridBagConstraints hideMenuContentPanelConstraint;
    GridBagConstraints showMenuHeaderPanelConstraint;
    GridBagConstraints showMenuContentPanelConstraint;
    GridBagConstraints outerContentPanelConstraint;
    public JPanel manageBackPanel;
    private int count = 0;
    // Danh sách các panel tương ứng với từng mục trong menu panel
    Map<String, PanyaContentPanel> panelDicts = new HashMap<>();


    final List<JLabel> menuListLabels = new ArrayList<JLabel>() {
        {
            add(homeLabel);
            add(storageLabel);
            add(recipeLabel);
            add(manageLabel);
        }
    };

    boolean randomColor = false;
    String recipeFile  = "Panya/src/main/resources/data/RecipeData/RecipeFile.json";
    String ingredientFile  = "Panya/src/main/resources/data/IngredientData/IngredientFile.json";
    
    private void initPanelDicts() {
        try {
            this.panelDicts = new HashMap<>() {
                {
                    put("HOME", new OuterContentPanel());
                    //put("MANAGE", new ManageWindow());
                    put("RECIPE", new RecipeMainPanel(recipeFile));
                    put("STORAGE", new StorageWindow());
                }
            };
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void initComponents() {
        loadAllData();
        this.initPanelDicts();
        this.initAction();
        this.initGridBagConstraints();
        this.replaceOuterPanel("HOME");
        this.menuIconLabel2.setVisible(false);
        this.hightlightFont = new java.awt.Font("Noto Sans", 1, 17);
        this.unhilightFont = new java.awt.Font("Noto Sans", 0, 17);
    }
    public void loadAllData() {
        final String pathMenuData = "Panya/src/main/resources/data/ManageData/MenuFile.json";
        menu = Menu.readMenuList(pathMenuData);
        System.out.println("test nhe" + menu.get(0).getProducts().get(0).getName());
        final String pathProductData = "Panya/src/main/resources/data/ManageData/ProductFile.json";
        products = Product.readProductList(pathProductData);
        // Thêm đọc data khác ở đây
    }
    public static List<Menu> getMenu()
    {
        return menu;
    }
    public static List<Product> getProducts()
    {
        return products;
    }

    public ApplicationWindow(String themeName) {
        super();
        initComponents();
        var theme = new Theme().getTheme(themeName);
        final var PRIMARY = theme.get(Theme.PRIMARY);
        final var LIGHT = theme.get(Theme.LIGHT);
        final var DARK = theme.get(Theme.DARK);

        this.initTheme(PRIMARY, LIGHT, DARK);
        this.setHighlightLabel(homeLabel);

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
        this.setHighlightLabel(homeLabel);

    }

    public ApplicationWindow(Color primary, Color light, Color dark, boolean randomColor) {
        super();
        initComponents();
        this.initTheme(primary, light, dark);
        this.setHighlightLabel(homeLabel);
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

        this.homeLabel.setBackground(primaryTextColor);
        this.imageLabel.setBackground(primaryTextColor);
        this.imagePanel.setBackground(primaryColor);

        if (darkTextColor.equals(Color.BLACK)) {
            this.menuIconLabel.setIcon(new ImageIcon(getClass().getResource("/images/baseline_menu_black_18dp.png")));
        }
        this.menuIconLabel.setBackground(darkColor);
        this.manageLabel.setForeground(lightTextColor);
        this.menuListPanel.setBackground(lightColor);
        this.menuPanel.setBackground(lightColor);
        this.recipeLabel.setForeground(lightTextColor);
        this.storageLabel.setBackground(lightColor);
        this.storageLabel.setForeground(lightTextColor);
        this.titlePanel.setBackground(darkColor);
        this.topHeaderLabel.setForeground(darkTextColor);
        this.topHeaderPanel.setBackground(darkColor);
        this.manageLabel.setBackground(lightColor);
        this.manageLabel.setForeground(lightTextColor);
        this.setHighlightLabel(this.homeLabel);
        this.unsetHighlightLabel(this.storageLabel);
        this.panelDicts.forEach((k, v) -> v.initTheme(primary, light, dark));
    }

    private void replaceOuterPanel(String labelName) {
        this.getContentPane().remove(this.outerContentPanel);
        this.outerContentPanel = (JPanel) this.panelDicts.get(labelName);
        this.getContentPane().add(this.outerContentPanel);

        var layout = (GridBagLayout) this.getContentPane().getLayout();
        layout.setConstraints(this.outerContentPanel, this.outerContentPanelConstraint);
        this.outerContentPanel.setVisible(true);

        this.outerContentPanel.revalidate();
        this.outerContentPanel.repaint();
    }

    private void initAction() {
        if(count == 0)
        {
            manageBackPanel = new ManageWindow();
            panelDicts.put("MANAGE", (PanyaContentPanel)manageBackPanel);
        }
        menuListLabels.forEach(lbl -> lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                highlightLabel(lbl);
                String labelName = lbl.getText();
                
                if(labelName.compareTo("MANAGE") == 0)
                {
                    //Đánh dấu sự ngu dốt, 1 ngày 1 đêm mới fix được =]]] cay.
                    if(count != 0)
                    {
                        panelDicts.replace("MANAGE", new ManageWindow());
                        replaceOuterPanel(labelName);
                    }
                    else
                    {
                        replaceOuterPanel(lbl.getText());
                        count++;
                    }
                }
                else
                {
                    replaceOuterPanel(labelName);
                }
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
        this.outerContentPanelConstraint = layout.getConstraints(this.outerContentPanel);
        showMenuHeaderPanelConstraint = layout.getConstraints(this.topHeaderPanel);
        showMenuContentPanelConstraint = layout.getConstraints(this.outerContentPanel);

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
                setHighlightLabel(lbl);
            } else {
                unsetHighlightLabel(jLabel);
            }
        }
    }

    private void setHighlightLabel(JLabel lbl) {
        lbl.setOpaque(true);
        lbl.setBackground(primaryColor);
        lbl.setForeground(primaryTextColor);
        lbl.setFont(this.hightlightFont);
    }

    private void unsetHighlightLabel(JLabel lbl) {
        lbl.setOpaque(true);
        lbl.setBackground(lightColor);
        lbl.setForeground(lightTextColor);
        lbl.setFont(this.unhilightFont);
    }

    private void showMenuActionPerformed() {
        var layout = (GridBagLayout) this.getContentPane().getLayout();

        if (this.menuPanel.isVisible()) {
            this.menuPanel.setVisible(false);
            this.menuIconLabel2.setVisible(true);
            layout.setConstraints(this.topHeaderPanel, this.hideMenuHeaderPanelConstraint);
            layout.setConstraints(this.outerContentPanel, this.hideMenuContentPanelConstraint);
        } else {
            this.menuPanel.setVisible(true);
            this.menuIconLabel2.setVisible(false);
            layout.setConstraints(this.outerContentPanel, this.showMenuContentPanelConstraint);
            layout.setConstraints(this.topHeaderPanel, this.showMenuHeaderPanelConstraint);
        }
        this.validate();
        this.repaint();
    }

}
