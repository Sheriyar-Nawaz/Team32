import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Contains the main method to start the application.
 */
public class Main {

    /**
     * The entry point of the application.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args){
        UserPass userPass = new UserPass(); // Create a new UserPass object to manage user credentials
        LoginGUI login = new LoginGUI(userPass.getLogininfo()); // Create a new LoginGUI object with the login information

        //Tests for methods added
        /*
        DishConstructionDB dishConstructionDB = new DishConstructionDB();
        Map<Integer, String> recipes = dishConstructionDB.getRecipes();
        for (Map.Entry<Integer, String> entry : recipes.entrySet()) {
            int recipeId = entry.getKey();
            String name = entry.getValue();
            System.out.println("Recipe ID: " + recipeId + ", Name: " + name);
        }
*/
        MenuCompDB menuCompDB = new MenuCompDB();
        List<Menu> menus = menuCompDB.getAllMenus();
        for (Menu menu: menus) {
            System.out.println(menu.getMenuId() + " " + menu.getMenuName() + " " + menu.getCreationDate() + " " + menu.getStatus());
        }

        Menu menu = menuCompDB.getMenu("Spring Specials");
        System.out.println(menu.getMenuId() + " " + menu.getMenuName() + " " + menu.getCreationDate() + " " + menu.getStatus());


    }
}
