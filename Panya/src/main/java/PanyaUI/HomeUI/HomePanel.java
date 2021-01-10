package PanyaUI.HomeUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.UIManager;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ColorUIResource;

import PanyaUI.ApplicationWindow;
import PanyaUI.Theme;

public class HomePanel extends HomePanelBase {

    /**
     *
     */
    private static final long serialVersionUID = 5065560730463211833L;
    ApplicationWindow parent;
    public HomePanel(ApplicationWindow parent) {
        super();
        this.parent = parent;
        initComponents();
    }

    public HomePanel(Color primary, Color light, Color dark) {
        super(primary, light, dark);
        initComponents();
    }

    void initComponents() {
        var allThemes = Theme.getThemeNames();
        List<Color> primaries = new ArrayList<>();
        // var t = new Theme();
        // for (var theme : allThemes) {
        //     primaries.add(t.getTheme(theme).get(Theme.PRIMARY));
        // }
        this.getThemeCombo().setModel(new DefaultComboBoxModel<>(primaries.toArray(allThemes)));
        this.getThemeCombo().addActionListener(e->{
            var themeStr = (String) this.getThemeCombo().getSelectedItem();
            var theme = new Theme().getTheme(themeStr);
            
            var primary = theme.get(Theme.PRIMARY);
            var light = theme.get(Theme.LIGHT);
            var dark = theme.get(Theme.DARK);

            var primaryResource = new ColorUIResource(primary);
            var darkResource = new ColorUIResource(dark);

            var textColor = new ColorUIResource(Theme.textColorFromBackgroundColor(dark));
            UIManager.put("Button[Default].background", primaryResource);
            UIManager.put("Button[Default].foreground", textColor);
            UIManager.put("Button.background", primaryResource);
            UIManager.put("Button.mouseHoverColor", darkResource);
            UIManager.put("Button.foreground", textColor);

            this.parent.initTheme(primary, light, dark);
        });
    }

    class ColorComboBoxEditor implements ComboBoxEditor {
        final protected JButton editor;

        protected EventListenerList listenerList = new EventListenerList();

        public ColorComboBoxEditor(Color initialColor) {
            editor = new JButton("");
            editor.setBackground(initialColor);
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Color currentBackground = editor.getBackground();
                    Color color = JColorChooser.showDialog(editor, "Color Chooser", currentBackground);
                    if ((color != null) && (currentBackground != color)) {
                        editor.setBackground(color);
                        fireActionEvent(color);
                    }
                }
            };
            editor.addActionListener(actionListener);
        }

        public void addActionListener(ActionListener l) {
            listenerList.add(ActionListener.class, l);
        }

        public Component getEditorComponent() {
            return editor;
        }

        public Object getItem() {
            return editor.getBackground();
        }

        public void removeActionListener(ActionListener l) {
            listenerList.remove(ActionListener.class, l);
        }

        public void selectAll() {
            // Ignore
        }

        public void setItem(Object newValue) {
            if (newValue instanceof Color) {
                Color color = (Color) newValue;
                editor.setBackground(color);
            } else {
                try {
                    Color color = Color.decode(newValue.toString());
                    editor.setBackground(color);
                } catch (NumberFormatException e) {
                }
            }
        }

        protected void fireActionEvent(Color color) {
            Object listeners[] = listenerList.getListenerList();
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == ActionListener.class) {
                    ActionEvent actionEvent = new ActionEvent(editor, ActionEvent.ACTION_PERFORMED, color.toString());
                    ((ActionListener) listeners[i + 1]).actionPerformed(actionEvent);
                }
            }
        }
    }

}
