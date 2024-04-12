import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuGUI extends GUI implements ActionListener {
    private JComboBox dishComboBox;
    private JButton addToMenuButton;
    private JButton finalizeMenuButton;
    private List<String> selectedDishes;

    public MenuGUI(String user) {
        super(user);
        selectedDishes = new ArrayList<>();
        JLabel dishLabel = new JLabel("Select Dish:");
        dishLabel.setForeground(Color.white);
        dishLabel.setBounds(50, 50, 100, 25);
        add(dishLabel);

        add(backButton);

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
        System.out.println(this.user);
        if (Objects.equals(this.user, "Head Chef")){
            add(finalizeMenuButton);
        }
        populateDishes(new String[]{"Spaghetti", "Salad", "Pizza"});
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
                JOptionPane.showMessageDialog(null, "Menu Finalized!", "Success", JOptionPane.PLAIN_MESSAGE);
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
}

