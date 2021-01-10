import javax.swing.SwingUtilities;
import com.formdev.flatlaf.IntelliJTheme;

/**
 *
 * @author dqh
 */
public class Main {

    public static void main(String[] args) {
        var themeName = "green";
        IntelliJTheme.install(Main.class.getResourceAsStream("theme/Light Owl.theme.json"));
        SwingUtilities.invokeLater(() -> new PanyaUI.ApplicationWindow(themeName).setVisible(true));
    }
}
