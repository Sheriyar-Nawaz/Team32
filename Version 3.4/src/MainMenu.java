import javax.swing.*;
import java.awt.*;

public class MainMenu extends GUI {
    //GUI Class was supposed to be like a very rough sketch of the main menu, feel free to use the code from their and change it up
    public MainMenu(){
        super();
        JButton recipeButton = new JButton("Recipes");
        JButton dishButton = new JButton("Dishes");
        JButton menusButton = new JButton("Menus");
        JButton orderButton = new JButton("Orders");
        JButton stockButton = new JButton("Stock");
        JButton wasteButton = new JButton("Waste Management");

        dishButton.setBounds(100,100,200,100);
        add(dishButton);


    }

}
