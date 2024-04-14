import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenuGUI extends GUI implements ActionListener {
    JButton recipeButton = new JButton("Recipes");
    JButton dishButton = new JButton("Dish Construction");
    JButton menusButton = new JButton("Menu Compilation");
    JButton orderButton = new JButton("Orders");
    JButton stockButton = new JButton("Stock");
    JButton wasteButton = new JButton("Waste Management");

    public MainMenuGUI(String user) {
        super(user);
        recipeButton.setBounds(100, 150, 200, 100);
        recipeButton.addActionListener(this);
        add(recipeButton);
        dishButton.setBounds(350, 150, 200, 100);
        dishButton.addActionListener(this);
        add(dishButton);
        menusButton.setBounds(600, 150, 200, 100);
        menusButton.addActionListener(this);
        add(menusButton);
        orderButton.setBounds(100, 350, 200, 100);
        orderButton.addActionListener(this);
        add(orderButton);
        stockButton.setBounds(350, 350, 200, 100);
        stockButton.addActionListener(this);
        add(stockButton);
        wasteButton.setBounds(600, 350, 200, 100);
        wasteButton.addActionListener(this);
        add(wasteButton);

        add(backButton);
        backButton.setText("Log out");
        backButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == recipeButton) {
            dispose();
            RecipesMenuGUI recipesMenuGUI = new RecipesMenuGUI(user);
        }
        if (e.getSource() == dishButton) {
            dispose();
            DishConstructionGUI dishGUI = new DishConstructionGUI(user);
        }
        if (e.getSource() == menusButton) {
            dispose();
            MenuCompGUI menuGUI = new MenuCompGUI(user);
        }
        if (e.getSource() == orderButton) {
            dispose();
            OrderGUI orderGUI = new OrderGUI(user);
        }
        if (e.getSource() == wasteButton) {
            dispose();
            WastemGUI wasteGUI = new WastemGUI(user);
        }

        if (e.getSource() == stockButton) {
            dispose();
            StockGUI stockGUI = new StockGUI(user);
        }
        if (e.getSource() == backButton) {
            dispose();
            LoginGUI loginGUI = new LoginGUI(new UserPass().getLogininfo());
        }

    }

}
