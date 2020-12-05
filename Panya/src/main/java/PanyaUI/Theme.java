package PanyaUI;

import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;

public class Theme {

    static final String COLOR_PALETTE_FILE = "theme/material-colors.json";
    static final String LIGHT = "300";
    static final String PRIMARY = "500";
    static final String DARK = "800";
    static final String[] THEME_NAMES;
    JSONObject colorPalette = null;

    static {
        THEME_NAMES = new String[] { "red", "pink", "purple", "deeppurple", "indigo", "blue", "lightblue", "cyan",
                "green", "lightgreen", "lime", "yellow", "amber", "orange", "deeporange", "brown", "grey", "bluegrey" };
    }

    /**
     * Get a java.awt.Color instance from a RGB str
     * https://stackoverflow.com/questions/4129666/how-to-convert-hex-to-rgb-using-java
     * 
     * @param colorStr e.g. "#FFFFFF"
     * @return a java.awt.Color instance
     */
    public static Color hex2Rgb(String colorStr) {
        return new Color(Integer.valueOf(colorStr.substring(1, 3), 16), Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }

    /**
     * Theme initialization Each Theme instance needs to be init colorPalette before
     * using
     */
    public Theme() {
        ClassLoader classLoader = this.getClass().getClassLoader();

        try (var fin = classLoader.getResourceAsStream(COLOR_PALETTE_FILE)) {
            this.colorPalette = new JSONObject(new String(fin.readAllBytes(), StandardCharsets.UTF_8));
        } catch (Exception e) {
            this.colorPalette = null;
        }
    }

    /**
     * Get recommended text color to fit with the background.
     * 
     * @param background background color
     * @return either java.awt.Color.BLACK or java.awt.Color.WHITE
     * @see java.awt.Colorw
     */
    public static Color textColorFromBackgroundColor(Color background) {
        var red = background.getRed();
        var green = background.getGreen();
        var blue = background.getBlue();

        // http://www.w3.org/TR/AERT#color-contrast
        var brightness = Math.round((red * 299 + green * 587 + blue * 114) / 1000);
        var whatColor = (brightness > 125) ? "black" : "white";
        return whatColor.equals("black") ? Color.BLACK : Color.WHITE;
    }

    public Map<String, Color> getTheme(String themeName) {
        if (this.colorPalette == null) {
            return null;
        }
        try {
            // get the color list from themeName
            var colorDict = this.colorPalette.getJSONObject(themeName);

            var theme = new HashMap<String, Color>();
            theme.put(LIGHT, Theme.hex2Rgb(colorDict.getString(LIGHT)));
            theme.put(PRIMARY, Theme.hex2Rgb(colorDict.getString(PRIMARY)));
            theme.put(DARK, Theme.hex2Rgb(colorDict.getString(DARK)));
            return theme;

        } catch (JSONException e) {
            return null;
        }

    }

    /**
     * Get a list of theme names that can be used to retrive the color from
     * PanyaUI.Theme.getTheme
     * 
     * @return an array of String, each element in the array is a theme name.
     * @see PanyaUI.Theme#getTheme(String)
     */
    public static String[] getThemeNames() {
        return Theme.THEME_NAMES.clone();
    }

    /**
     * Get a random theme name that can be used to retrive the color from
     * PanyaUI.Theme.getTheme
     * 
     * @return a String represents a theme name
     */
    public static String getRandomThemeName() {
        int rnd = new Random().nextInt(Theme.THEME_NAMES.length);
        return Theme.THEME_NAMES[rnd];
    }
}
