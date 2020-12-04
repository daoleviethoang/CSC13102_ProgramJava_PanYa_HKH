package PanyaCore;

import java.util.ArrayList;
import java.util.List;

public class Store {
    String name;
    String secretPassword;
    Menu menu;
    List<CustomProduct> customMenu = new ArrayList<CustomProduct>();
    List<Recipe> recipeList = new ArrayList<Recipe>();
    History history;

    Store(String name, String secretPassword, Menu menu, List<CustomProduct> customMenu, List<Recipe> recipeList,
            History history) {
        this.name = name;
        this.secretPassword = secretPassword;
        this.menu = menu;
        this.customMenu = customMenu;
        this.recipeList = recipeList;
        this.history = history;
    }
}
