import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the graphical user interface for waste management.
 */
public class WastemGUI extends GUI implements ActionListener {
    // Components
    private JTextField ingredientComboBox;
    private JButton addToWasteButton;

    /**
     * Constructs the waste management GUI.
     *
     * @param user The type of user logged in
     */
    public WastemGUI(String user) {
        super(user); // Call superclass constructor
        setTitle("Waste Management"); // Set title of the window

        logo.setBounds(300, -50, 300, 300); // Set logo position
        add(logo); // Add logo to the frame

        JLabel ingredientLabel = new JLabel("Select Ingredient:"); // Create a label for ingredient selection
        ingredientLabel.setForeground(Color.white); // Set text color to white
        ingredientLabel.setBounds(300, 400, 150, 25); // Set label position
        add(ingredientLabel); // Add label to the frame

        add(backButton); // Add back button to the frame
        backButton.addActionListener(this); // Add action listener to back button

        ingredientComboBox = new JTextField(); // Create a text field for ingredient selection
        ingredientComboBox.setBounds(410, 400, 200, 25); // Set text field position
        add(ingredientComboBox); // Add text field to the frame

        addToWasteButton = new JButton("Add to Waste"); // Create a button to add ingredient to waste
        addToWasteButton.setBounds(390, 550, 150, 25); // Set button position
        addToWasteButton.addActionListener(this); // Add action listener to the button
        add(addToWasteButton); // Add button to the frame

        setVisible(true); // Set frame visibility
    }

    /**
     * Handles button click events.
     *
     * @param e The action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToWasteButton) { // If add to waste button is clicked
            String selectedIngredient = (String) ingredientComboBox.getText(); // Get selected ingredient
            // Here you can add the selected ingredient to waste
            // For now, let's just print it
            System.out.println("Selected ingredient added to waste: " + selectedIngredient);
            JOptionPane.showMessageDialog(this, "Added to Waste: " + selectedIngredient); // Show message dialog
        }
        if (e.getSource() == backButton) { // If back button is clicked
            dispose(); // Close the window
            MainMenuGUI mm = new MainMenuGUI(user); // Open the main menu GUI
        }
    }
}
