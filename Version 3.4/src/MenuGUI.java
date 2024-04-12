import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuGUI extends GUI implements ActionListener {
    private JComboBox<Object> dishComboBox;
    private JButton addToMenuButton;
    private JButton finalizeMenuButton;
    private List<String> selectedDishes;

    public MenuGUI(String user) {
        super(user);
        selectedDishes = new ArrayList<>();
        JLabel dishLabel = new JLabel("Select Dish:");
        dishLabel.setForeground(Color.white);
        dishLabel.setBounds(250, 300, 100, 25);
        add(dishLabel);

        add(backButton);
        backButton.addActionListener(this);

        logo.setBounds(300,0,300,300);
        add(logo);

        dishComboBox = new JComboBox<>();
        dishComboBox.setBounds(325,300,200,25);
        add(dishComboBox);

        addToMenuButton = new JButton("Add to Menu");
        addToMenuButton.setBounds(350,350,150,25);
        addToMenuButton.addActionListener(this);
        add(addToMenuButton);

        finalizeMenuButton = new JButton("Finalize Menu");
        finalizeMenuButton.setBounds(350,400,150,25);
        finalizeMenuButton.addActionListener(this);
        if (!Objects.equals(user, "Head Chef")){
            finalizeMenuButton.setEnabled(false);
        }
        add(finalizeMenuButton);
        populateDishes(new String[]{"Spaghetti", "Salad", "Pizza"});

        revalidate();
        repaint();
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
        } if (e.getSource() == finalizeMenuButton) {
            if (!selectedDishes.isEmpty()) {
                // Here you can finalize the menu
                // For now, let's just print a message
                System.out.println("Menu finalized!");
                JOptionPane.showMessageDialog(null, "Menu Finalized!", "Success", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Menu is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }


    // Dummy dish data for demonstration
    public void populateDishes(String[] dishNames) {
        for (String dishName : dishNames) {
            dishComboBox.addItem(dishName);
        }
    }
}

