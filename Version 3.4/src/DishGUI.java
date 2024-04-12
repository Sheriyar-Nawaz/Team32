import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DishGUI extends GUI implements ActionListener {
    private JComboBox<String> recipeComboBox;
    private JButton addButton;

    public DishGUI(String user) {
        super(user);
        setTitle("Dish");

        JLabel recipeLabel = new JLabel("Select Recipe:");
        recipeLabel.setForeground(Color.white);
        recipeLabel.setBounds(50, 50, 100, 25);
        add(recipeLabel);

        add(backButton);
        backButton.addActionListener(this);

        recipeComboBox = new JComboBox<>();
        recipeComboBox.setBounds(160, 50, 200, 25);
        add(recipeComboBox);

        // Add some sample recipes
        recipeComboBox.addItem("Recipe 1");
        recipeComboBox.addItem("Recipe 2");
        recipeComboBox.addItem("Recipe 3");

        addButton = new JButton("Add to Dish");
        addButton.setBounds(160, 100, 150, 25);
        addButton.addActionListener(this);
        add(addButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String selectedRecipe = (String) recipeComboBox.getSelectedItem();
            // Here you can add the selected recipe to the dish
            // For now, let's just print it
            System.out.println("Selected recipe: " + selectedRecipe);
            JOptionPane.showMessageDialog(this, "Recipe added to dish: " + selectedRecipe);
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }

}
