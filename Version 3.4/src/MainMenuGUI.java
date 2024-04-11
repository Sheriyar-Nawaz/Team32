import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenuGUI extends GUI implements ActionListener {
    //GUI Class was supposed to be like a very rough sketch of the main menu, feel free to use the code from their and change it up

    JButton recipeButton = new JButton("Recipes");
    JButton dishButton = new JButton("Dishes");
    JButton menusButton = new JButton("Menus");
    JButton orderButton = new JButton("Orders");
    JButton stockButton = new JButton("Stock");
    JButton wasteButton = new JButton("Waste Management");

    public MainMenuGUI(){
        super();
        recipeButton.setBounds(100,100,200,100);
        recipeButton.addActionListener(this);
        add(recipeButton);
        dishButton.setBounds(350,100,200,100);
        dishButton.addActionListener(this);
        add(dishButton);
        menusButton.setBounds(600,100,200,100);
        menusButton.addActionListener(this);
        add(menusButton);
        orderButton.setBounds(100,300,200,100);
        orderButton.addActionListener(this);
        add(orderButton);
        stockButton.setBounds(350,300,200,100);
        stockButton.addActionListener(this);
        add(stockButton);
        wasteButton.setBounds(600,300,200,100);
        wasteButton.addActionListener(this);
        add(wasteButton);

        revalidate();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == dishButton) {
            dispose();
            DishGUI dishGUI = new DishGUI();
        }
        if (e.getSource() == menusButton) {
            dispose();
            MenuGUI menuGUI = new MenuGUI();
        }
        if (e.getSource() == orderButton) {
            dispose();
            OrderGUI orderGUI = new OrderGUI();
        }
        if (e.getSource() == wasteButton) {
            dispose();
            WastemGUI wasteGUI = new WastemGUI();
        }


    }
}
