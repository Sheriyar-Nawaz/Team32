import javax.swing.*;

public class MainMenuGUI extends GUI {
    //GUI Class was supposed to be like a very rough sketch of the main menu, feel free to use the code from their and change it up
    public MainMenuGUI(){
        super();
        JButton recipeButton = new JButton("Recipes");
        JButton dishButton = new JButton("Dishes");
        JButton menusButton = new JButton("Menus");
        JButton orderButton = new JButton("Orders");
        JButton stockButton = new JButton("Stock");
        JButton wasteButton = new JButton("Waste Management");

        recipeButton.setBounds(100,100,200,100);
        add(recipeButton);
        dishButton.setBounds(300,100,200,100);
        add(dishButton);
        menusButton.setBounds(500,100,200,100);
        add(menusButton);
        orderButton.setBounds(100,300,200,100);
        add(orderButton);
        stockButton.setBounds(300,300,200,100);
        add(stockButton);
        wasteButton.setBounds(500,300,200,100);
        add(wasteButton);


    }

}
