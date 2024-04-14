import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class RecipeCreateGUI extends GUI implements ActionListener {
    private final JButton addToRecipeButton;
    private final JButton removeFromRecipeButton;
    private final JButton createRecipeButton;
    private final JButton submitForReviewButton;
    private final JButton saveAsDraftButton;
    private JComboBox<String> recipeComboBox;
    JFrame frame;
    private JButton createButton;
    private JButton addButton;

    public RecipeCreateGUI(String user) {
        super(user);

        add(backButton);
        backButton.addActionListener(this);

        logo.setBounds(270,-50,300,300);
        add(logo);

        //selectedRecipes = new ArrayList<>();
        JLabel ingredientLabel = new JLabel("Available Ingredients");
        ingredientLabel.setForeground(Color.white);
        ingredientLabel.setBounds(50, 300, 200, 25);
        add(ingredientLabel);
        JList<String> ingredientList = new JList<>(new String[]{"eggs", "flour", "butter"});
        JScrollPane ingredientScrollPane = new JScrollPane(ingredientList);
        ingredientScrollPane.setBounds(50,325,200,275);
        ingredientList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(ingredientScrollPane);

        JLabel recipeLabel = new JLabel("Selected Recipe");
        recipeLabel.setForeground(Color.white);
        recipeLabel.setBounds(650, 300, 100, 25);
        add(recipeLabel);
        JScrollPane recipeScrollPane = new JScrollPane(ingredientList);
        recipeScrollPane.setBounds(650,325,200,275);
        ingredientList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(recipeScrollPane);

        JLabel selectRecipeLabel = new JLabel("Select Recipe");
        selectRecipeLabel.setForeground(Color.white);
        selectRecipeLabel.setBounds(50, 175, 100, 25);
        add(selectRecipeLabel);
        recipeComboBox = new JComboBox<>();
        recipeComboBox.setBounds(50,200,200,25);
        add(recipeComboBox);

        addToRecipeButton = new JButton("Add to Recipe");
        addToRecipeButton.setBounds(50,600,200,25);
        addToRecipeButton.addActionListener(this);
        add(addToRecipeButton);

        removeFromRecipeButton = new JButton("Remove from Recipe");
        removeFromRecipeButton.setBounds(650,600,200,25);
        removeFromRecipeButton.addActionListener(this);
        add(removeFromRecipeButton);

        createRecipeButton = new JButton("Create New Recipe");
        createRecipeButton.setBounds(350,250,150,75);
        createRecipeButton.addActionListener(this);
        add(createRecipeButton);

        submitForReviewButton = new JButton("Submit for Review");
        submitForReviewButton.setBounds(350,400,150,75);
        submitForReviewButton.addActionListener(this);
        add(submitForReviewButton);

        saveAsDraftButton = new JButton("Save as Draft");
        saveAsDraftButton.setBounds(350,550,150,75);
        saveAsDraftButton.addActionListener(this);
        add(saveAsDraftButton);

        revalidate();
        repaint();
    }

    public void createRecipeGUI(){
        frame = new JFrame();
        frame.setTitle("Create Dish");
        frame.setResizable(false);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JTextField dishNameField = new JTextField();
        dishNameField.setBounds(100, 50, 150, 20);
        frame.add(dishNameField);

        createButton = new JButton("Create");
        createButton.setBounds(100,100,100,25);
        createButton.addActionListener(this);
        frame.add(createButton);

        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToRecipeButton) {

        } if (e.getSource() == createRecipeButton) {
            createRecipeGUI();
        } if (e.getSource() == createButton) {
            frame.dispose();
        }
        if (e.getSource() == addButton) {
            String selectedRecipe = (String) recipeComboBox.getSelectedItem();
            // Here you can add the selected recipe to the dish
            // For now, let's just print it
            System.out.println("Selected recipe: " + selectedRecipe);
            JOptionPane.showMessageDialog(this, "Recipe added to dish: " + selectedRecipe);
        }
        if (e.getSource() == backButton){
            dispose();
            RecipesMenuGUI rm = new RecipesMenuGUI(user);
        }
    }
}
