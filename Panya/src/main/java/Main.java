import javax.swing.SwingUtilities;
import javax.swing.UIManager;

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
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> new PanyaUI.ApplicationWindow(true).setVisible(true));
    }
}
