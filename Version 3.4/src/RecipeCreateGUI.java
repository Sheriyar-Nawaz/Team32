import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class RecipeCreateGUI extends GUI implements ActionListener {
    private final JButton addToDishButton;
    private final JButton createDishButton;
    private final JButton finalizeDishButton;
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
        ingredientLabel.setBounds(50, 300, 100, 25);
        add(ingredientLabel);
        JList<String> ingredientList = new JList<>(new String[]{"eggs", "flour", "butter"});
        JScrollPane ingredientScrollPane = new JScrollPane(ingredientList);
        ingredientScrollPane.setBounds(50,325,200,275);
        ingredientList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(ingredientScrollPane);

        JLabel recipeLabel = new JLabel("Recipe");
        recipeLabel.setForeground(Color.white);
        recipeLabel.setBounds(650, 300, 100, 25);
        add(recipeLabel);
        JList<String> dish = new JList<>(new String[]{"1", "2", "3"});
        JScrollPane dishScrollPane = new JScrollPane(dish);
        dishScrollPane.setBounds(650,325,200,275);
        dish.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(dishScrollPane);

        JLabel selectRecipeLabel = new JLabel("Select Recipe");
        selectRecipeLabel.setForeground(Color.white);
        selectRecipeLabel.setBounds(50, 175, 100, 25);
        add(selectRecipeLabel);
        JComboBox<Object> RecipeComboBox = new JComboBox<>();
        RecipeComboBox.setBounds(50,200,200,25);
        add(RecipeComboBox);

        addToDishButton = new JButton("Add to Recipe");
        addToDishButton.setBounds(50,600,200,25);
        addToDishButton.addActionListener(this);
        add(addToDishButton);

        createDishButton = new JButton("Create New Recipe");
        createDishButton.setBounds(350,250,150,75);
        createDishButton.addActionListener(this);
        add(createDishButton);

        finalizeDishButton = new JButton("Submit");
        finalizeDishButton.setBounds(350,400,150,75);
        finalizeDishButton.addActionListener(this);

        revalidate();
        repaint();
    }

    public void createDishGUI(){
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
        if (e.getSource() == addToDishButton) {
            //String selectedDish = (String) scrollPane.getSelectedItem();
            // selectedDishes.add(selectedDish);
            // Here you can add the selected dish to the menu
            // For now, let's just print it
            //System.out.println("Selected dish: " + selectedDish);
            //JOptionPane.showMessageDialog(null, "Dish added to menu: " + selectedDish);
        } if (e.getSource() == createDishButton) {
            createDishGUI();
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
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }
}
