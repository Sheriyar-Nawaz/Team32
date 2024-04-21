import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Represents the graphical user interface for constructing dishes.
 * Extends the GUI class and implements the ActionListener interface.
 */
public class DishConstructionGUI extends GUI implements ActionListener {
    /** Button for adding ingredients to the dish */
    private final JButton addToDishButton;

    /** Button for creating a new dish */
    private final JButton createDishButton;

    /** Button for finalizing the dish */
    private final JButton finalizeDishButton;

    /** Combo box for selecting recipes */
    private JComboBox<String> recipeComboBox;

    /** Frame for creating dishes */
    JFrame frame;

    /** Button for creating dishes */
    private JButton createButton;

    /** Button for removing ingredients from the recipe */
    private final JButton removeFromRecipeButton;

    /** Button for adding ingredients */
    private JButton addButton;
    JTextField dishNameField;

    /** Button for removing ingredients */
    private JButton removeButton;

    /** Combo box for selecting dishes */
    JComboBox<Object> dishComboBox;
    Map<Integer, String> dishMap;

    /** Map to store recipe IDs and names */
    Map<Integer, String> recipeMap;

    /** Map to store recipe IDs and ingredient names */
    Map<Integer, String> dishRecipeMap;

    /** Map to store ingredient IDs and names */
    Map<Integer, String> ingredientsMap;

    /** List for displaying recipe ingredients */
    JList<String> dishRecipes;
    JList<String> recipeJList;

    /** List for displaying available ingredients */
    JList<String> ingredients;

    /** Database object for accessing recipes */
    RecipesDB rdb = new RecipesDB();
    DishConstructionDB dcdb;

    /**
     * Constructs a new DishConstructionGUI object with the specified user.
     *
     * @param user The logged-in user.
     */
    public DishConstructionGUI(String user) {
        super(user);

        // Add back button
        add(backButton);
        backButton.addActionListener(this);

        // Set position and size of the logo
        logo.setBounds(270,-50,300,300);
        add(logo);

        // Display label for selecting dish
        JLabel selectDishLabel = new JLabel("Select Dish");
        selectDishLabel.setForeground(Color.white);
        selectDishLabel.setBounds(50, 175, 100, 25);
        add(selectDishLabel);

        dcdb = new DishConstructionDB();
        dishMap = dcdb.getDishes();
        List<String> dishList = new ArrayList<>(dishMap.values());
        dishComboBox = new JComboBox<>(dishList.toArray(new String[0]));
        dishComboBox.setBounds(50,200,200,25);
        dishComboBox.addActionListener(this);
        add(dishComboBox);

        // Get available recipes
        JLabel recipeLabel = new JLabel("Available Recipes:");
        recipeLabel.setForeground(Color.white);
        recipeLabel.setBounds(50, 300, 125, 25);
        add(recipeLabel);

        recipeMap = rdb.getRecipes();
        List<String> recipeList = new ArrayList<>(recipeMap.values());
        recipeJList = new JList<>(recipeList.toArray(new String[0]));
        JScrollPane recipeScrollPane = new JScrollPane(recipeJList);
        recipeScrollPane.setBounds(50,325,200,275);
        //recipeJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(recipeScrollPane);

        // Display dish label and selection
        JLabel dishLabel = new JLabel("Selected Dish Recipes:");
        dishLabel.setForeground(Color.white);
        dishLabel.setBounds(650, 300, 125, 25);
        add(dishLabel);

        dishRecipeMap = dcdb.getDishRecipes(getDishID(dishMap));
        if (dishRecipeMap != null) {
            List<String> DishRecipeList = new ArrayList<>(dishRecipeMap.values());
            dishRecipes = new JList<>((DishRecipeList.toArray(new String[0])));
        }
        JScrollPane dishRecipeScrollPane = new JScrollPane(dishRecipes);
        dishRecipeScrollPane.setBounds(650,325,200,275);
        //dishRecipes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(dishRecipeScrollPane);


        // Add buttons for dish operations
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

        removeFromRecipeButton = new JButton("Remove from Dish");
        removeFromRecipeButton.setBounds(650,600,200,25);
        removeFromRecipeButton.addActionListener(this);
        add(removeFromRecipeButton);

        revalidate();
        repaint();
    }


    public int getDishID(Map<Integer, String> map){
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            if (Objects.equals(entry.getValue(), Objects.requireNonNull(dishComboBox.getSelectedItem()).toString())){
                return entry.getKey();
            }
        }
        return 0;
    }

    public int getRecipeID(Map<Integer, String> map, JList<String> jlist){
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            if (Objects.equals(entry.getValue(), Objects.requireNonNull(jlist.getSelectedValue()))){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * Creates the GUI for creating a new dish.
     */
    public void createDishGUI(){
        frame = new JFrame();
        frame.setTitle("Create Dish");
        frame.setResizable(false);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel dishNameLabel = new JLabel("Enter Dish Name: ");
        dishNameLabel.setBounds(20, 50, 150, 20);
        frame.add(dishNameLabel);

        dishNameField = new JTextField();
        dishNameField.setBounds(120, 50, 150, 20);
        frame.add(dishNameField);

        createButton = new JButton("Create");
        createButton.setBounds(100,100,100,25);
        createButton.addActionListener(this);
        frame.add(createButton);

        frame.revalidate();
        frame.repaint();
    }

    /**
     * Invoked when an action occurs, such as clicking on a button.
     *
     * @param e The ActionEvent that occurred.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createDishButton) {
            createDishGUI();
        } if (e.getSource() == createButton) {
            frame.dispose();
            dcdb.createNewDish(dishNameField.getText());
            JOptionPane.showMessageDialog(null, "Dish Added!", "Added", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == addToDishButton) {
            dcdb.InsertRecipeToDish(getDishID(dishMap), getRecipeID(recipeMap, recipeJList));
        }
        if (e.getSource() == removeFromRecipeButton) {
            dcdb.removeFromDish(getRecipeID(dishRecipeMap, dishRecipes));
        }
        if (e.getSource() == addButton) {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Recipe Added!", "Added", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == removeButton){
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Recipe Removed!", "Removed", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == finalizeDishButton){
            JOptionPane.showMessageDialog(null, "Dish Finalised", "Finalised!", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == dishComboBox){
            // Clear the selection in the JList
            dishRecipes.clearSelection();

            // Get the ID of the selected recipe
            int dishID = getDishID(dishMap);

            // Get the ingredients for the selected recipe
            dishRecipeMap = dcdb.getDishRecipes(dishID);
            List<String> dishrecipeList = new ArrayList<>(dishRecipeMap.values());

            // Update the data in the existing JList
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String recipe : dishrecipeList) {
                listModel.addElement(recipe);
            }
            dishRecipes.setModel(listModel);
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }
}

