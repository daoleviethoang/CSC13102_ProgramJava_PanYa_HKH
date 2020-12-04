import PanyaUI.Theme;
/**
 *
 * @author dqh
 */
public class Main {

    public static void main(String[] args){

        var primary = Theme.hex2Rgb("#90a4ae");
        var light = Theme.hex2Rgb("#c1d5e0");
        var dark = Theme.hex2Rgb("#62757f");
        new PanyaUI.TestMain(primary, light, dark).setVisible(true);
    }
}
