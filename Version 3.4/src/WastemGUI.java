import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WastemGUI extends GUI implements ActionListener {
    private JComboBox<String> ingredientComboBox;
    private JButton addToWasteButton;

    public WastemGUI(String user) {
        super(user);
        setTitle("Waste Management");

        JLabel ingredientLabel = new JLabel("Select Ingredient:");
        ingredientLabel.setForeground(Color.white);
        ingredientLabel.setBounds(50, 50, 150, 25);
        add(ingredientLabel);

        add(backButton);
        backButton.addActionListener(this);

        ingredientComboBox = new JComboBox<>();
        ingredientComboBox.setBounds(200, 50, 200, 25);
        add(ingredientComboBox);

        // Adding some sample ingredients
        ingredientComboBox.addItem("Ingredient 1");
        ingredientComboBox.addItem("Ingredient 2");
        ingredientComboBox.addItem("Ingredient 3");

        addToWasteButton = new JButton("Add to Waste");
        addToWasteButton.setBounds(200, 100, 150, 25);
        addToWasteButton.addActionListener(this);
        add(addToWasteButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToWasteButton) {
            String selectedIngredient = (String) ingredientComboBox.getSelectedItem();
            // Here you can add the selected ingredient to waste
            // For now, let's just print it
            System.out.println("Selected ingredient added to waste: " + selectedIngredient);
            JOptionPane.showMessageDialog(this, "Added to Waste: " + selectedIngredient);
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }
}
//iyfkjhg