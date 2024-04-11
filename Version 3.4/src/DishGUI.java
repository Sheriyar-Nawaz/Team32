import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DishGUI extends JFrame implements ActionListener {
    private JComboBox<String> recipeComboBox;
    private JButton addButton;

    public DishGUI() {
        setTitle("Dish");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel recipeLabel = new JLabel("Select Recipe:");
        recipeLabel.setBounds(50, 50, 100, 25);
        add(recipeLabel);

        recipeComboBox = new JComboBox<>();
        recipeComboBox.setBounds(160, 50, 200, 25);
        add(recipeComboBox);

        // Add some sample recipes
        recipeComboBox.addItem("Recipe 1");
        recipeComboBox.addItem("Recipe 2");
        recipeComboBox.addItem("Recipe 3");

        addButton = new JButton("Add Recipe");
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DishGUI::new);
    }
}
