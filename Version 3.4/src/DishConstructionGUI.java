import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class DishConstructionGUI extends GUI implements ActionListener {
    private final JButton addToDishButton;
    private final JButton createDishButton;
    private final JButton finalizeDishButton;
    private JComboBox<String> recipeComboBox;
    JFrame frame;
    private JButton createButton;

    private final JButton removeFromRecipeButton;

    private JButton addButton;

    public DishConstructionGUI(String user) {
        super(user);

        add(backButton);
        backButton.addActionListener(this);

        logo.setBounds(270,-50,300,300);
        add(logo);

        //selectedRecipes = new ArrayList<>();
        JLabel recipeLabel = new JLabel("Available Recipes");
        recipeLabel.setForeground(Color.white);
        recipeLabel.setBounds(50, 300, 100, 25);
        add(recipeLabel);
        JList<String> recipeList = new JList<>(new String[]{"1", "2", "3"});
        JScrollPane recipeScrollPane = new JScrollPane(recipeList);
        recipeScrollPane.setBounds(50,325,200,275);
        recipeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(recipeScrollPane);

        JLabel dishLabel = new JLabel("Dish");
        dishLabel.setForeground(Color.white);
        dishLabel.setBounds(650, 300, 100, 25);
        add(dishLabel);
        JList<String> dish = new JList<>(new String[]{"1", "2", "3"});
        JScrollPane dishScrollPane = new JScrollPane(dish);
        dishScrollPane.setBounds(650,325,200,275);
        dish.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(dishScrollPane);

        JLabel selectDishLabel = new JLabel("Select Dish");
        selectDishLabel.setForeground(Color.white);
        selectDishLabel.setBounds(50, 175, 100, 25);
        add(selectDishLabel);
        JComboBox<Object> dishComboBox = new JComboBox<>();
        dishComboBox.setBounds(50,200,200,25);
        add(dishComboBox);

        addToDishButton = new JButton("Add to Dish");
        addToDishButton.setBounds(50,600,200,25);
        addToDishButton.addActionListener(this);
        add(addToDishButton);

        createDishButton = new JButton("Create New Dish");
        createDishButton.setBounds(350,250,150,75);
        createDishButton.addActionListener(this);
        add(createDishButton);

        finalizeDishButton = new JButton("Finalise Dish");
        finalizeDishButton.setBounds(350,400,150,75);
        finalizeDishButton.addActionListener(this);
        if (!Objects.equals(user, "Head Chef")){
            finalizeDishButton.setEnabled(false);
        }
        add(finalizeDishButton);

        removeFromRecipeButton = new JButton("Remove from Recipe");
        removeFromRecipeButton.setBounds(650,600,200,25);
        removeFromRecipeButton.addActionListener(this);
        add(removeFromRecipeButton);

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
