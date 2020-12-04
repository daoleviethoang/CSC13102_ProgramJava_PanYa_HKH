import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

import java.awt.Color;
import org.json.JSONObject;

import PanyaUI.Theme;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dqh
 */
public class Main {

    public static void main(String[] args){
        new PanyaUI.TestMain(PanyaUI.Theme.getRandomThemeName(), true).setVisible(true);
        // var primary = Theme.hex2Rgb("#90a4ae");
        // var light = Theme.hex2Rgb("#c1d5e0");
        // var dark = Theme.hex2Rgb("#62757f");
        // new PanyaUI.TestMain(primary, light, dark).setVisible(true);
    }
}
