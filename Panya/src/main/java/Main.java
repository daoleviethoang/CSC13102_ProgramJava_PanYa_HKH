import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 *
 * @author dqh
 */
public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {

        }

        SwingUtilities.invokeLater(() -> new PanyaUI.TestMain().setVisible(true));
    }
}
