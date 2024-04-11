import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu extends GUI implements ActionListener {
    private JComboBox<String> dishComboBox;
    private JButton addToMenuButton;
    private JButton finalizeMenuButton;
    private List<String> selectedDishes;

    public Menu() {
        initializeComponents();
        selectedDishes = new ArrayList<>();
    }

    private void initializeComponents() {
        JLabel dishLabel = new JLabel("Select Dish:");
        dishLabel.setBounds(50, 50, 100, 25);
        add(dishLabel);

        dishComboBox = new JComboBox<>();
        dishComboBox.setBounds(160, 50, 200, 25);
        add(dishComboBox);

        addToMenuButton = new JButton("Add to Menu");
        addToMenuButton.setBounds(50, 100, 150, 25);
        addToMenuButton.addActionListener(this);
        add(addToMenuButton);

        finalizeMenuButton = new JButton("Finalize Menu");
        finalizeMenuButton.setBounds(220, 100, 150, 25);
        finalizeMenuButton.addActionListener(this);
        add(finalizeMenuButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToMenuButton) {
            String selectedDish = (String) dishComboBox.getSelectedItem();
            selectedDishes.add(selectedDish);
            // Here you can add the selected dish to the menu
            // For now, let's just print it
            System.out.println("Selected dish: " + selectedDish);
            JOptionPane.showMessageDialog(null, "Dish added to menu: " + selectedDish);
        } else if (e.getSource() == finalizeMenuButton) {
            if (!selectedDishes.isEmpty()) {
                // Here you can finalize the menu
                // For now, let's just print a message
                System.out.println("Menu finalized!");
                JOptionPane.showMessageDialog(null, "Menu Finalized!", "Sucess", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Menu is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    // Dummy dish data for demonstration
    public void populateDishes(String[] dishNames) {
        for (String dishName : dishNames) {
            dishComboBox.addItem(dishName);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu() {
                // Dummy implementation of abstract method
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            };
            // Dummy dish data
            menu.populateDishes(new String[]{"Spaghetti", "Salad", "Pizza"});
        });
    }
}

