import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import PanyaUI.Theme;
import mdlaf.MaterialLookAndFeel;

/**
 *
 * @author dqh
 */
public class Main {

    public static void main(String[] args) {

        // try {
        //     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // } catch (Exception ignored) {

        // }
        var themeName = "green";
        var theme = new Theme().getTheme(themeName);
        // var light = new ColorUIResource(theme.get("300"));
        var primary = new ColorUIResource(theme.get("500"));
        var dark = new ColorUIResource(theme.get("800"));
        var textColor = new ColorUIResource(Theme.textColorFromBackgroundColor(dark));

        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());

            UIManager.put("Button.background", primary);
            UIManager.put("Button.mouseHoverColor", dark);
            UIManager.put("Button.foreground", textColor);
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> new PanyaUI.ApplicationWindow(themeName).setVisible(true));
    }
}
