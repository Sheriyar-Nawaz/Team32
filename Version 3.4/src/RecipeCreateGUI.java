import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

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
    private JButton removeButton;
    Map<Integer, String> recipeMap;
    Map<Integer, String> recipeIngredientMap;
    Map<Integer, String> ingredientsMap;
    JList<String> recipeIngredients;
    JList<String> ingredients;
    RecipesDB rdb;
    JTextField quantityField;

    public RecipeCreateGUI(String user) {
        super(user);

        add(backButton);
        backButton.addActionListener(this);

        logo.setBounds(300,-50,300,300);
        add(logo);

        //selectedRecipes = new ArrayList<>();
        JLabel ingredientLabel = new JLabel("Available Ingredients");
        ingredientLabel.setForeground(Color.white);
        ingredientLabel.setBounds(50, 300, 200, 25);
        add(ingredientLabel);

        rdb = new RecipesDB();
        ingredientsMap = rdb.getIngredients();
        List<String> ingredientsList = new ArrayList<>(ingredientsMap.values());
        ingredients = new JList<>((ingredientsList.toArray(new String[0])));
        JScrollPane ingredientScrollPane = new JScrollPane(ingredients);
        ingredientScrollPane.setBounds(50,325,200,275);
        ingredients.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(ingredientScrollPane);

        JLabel recipeLabel = new JLabel("Selected Recipe");
        recipeLabel.setForeground(Color.white);
        recipeLabel.setBounds(650, 300, 100, 25);
        add(recipeLabel);






        JLabel selectRecipeLabel = new JLabel("Select Recipe");
        selectRecipeLabel.setForeground(Color.white);
        selectRecipeLabel.setBounds(50, 175, 100, 25);
        add(selectRecipeLabel);

        recipeMap = rdb.getRecipes();
        List<String> recipeList = new ArrayList<>(recipeMap.values());
        recipeComboBox = new JComboBox<>(recipeList.toArray(new String[0]));
        recipeComboBox.setBounds(50,200,200,25);
        recipeComboBox.addActionListener(this);
        add(recipeComboBox);

        recipeIngredientMap = rdb.getRecipeIngredients(getRecipeID(recipeMap));
        List<String> recipeIngredientList = new ArrayList<>(recipeIngredientMap.values());
        recipeIngredients = new JList<>((recipeIngredientList.toArray(new String[0])));
        JScrollPane recipeScrollPane = new JScrollPane(recipeIngredients);
        recipeScrollPane.setBounds(650,325,200,275);
        recipeIngredients.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(recipeScrollPane);

        addToRecipeButton = new JButton("Add to Recipe");
        addToRecipeButton.setBounds(50,600,200,25);
        addToRecipeButton.addActionListener(this);
        add(addToRecipeButton);

        removeFromRecipeButton = new JButton("Remove from Recipe");
        removeFromRecipeButton.setBounds(650,600,200,25);
        removeFromRecipeButton.addActionListener(this);
        //add(removeFromRecipeButton);

        createRecipeButton = new JButton("Create New Recipe");
        createRecipeButton.setBounds(375,250,150,75);
        createRecipeButton.addActionListener(this);
        //add(createRecipeButton);

        submitForReviewButton = new JButton("Submit for Review");
        submitForReviewButton.setBounds(375,400,150,75);
        submitForReviewButton.addActionListener(this);
        add(submitForReviewButton);

        saveAsDraftButton = new JButton("Save as Draft");
        saveAsDraftButton.setBounds(375,550,150,75);
        saveAsDraftButton.addActionListener(this);
        add(saveAsDraftButton);

        revalidate();
        repaint();
    }

    public int getRecipeID(Map<Integer, String> map){
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            if (Objects.equals(entry.getValue(), Objects.requireNonNull(recipeComboBox.getSelectedItem()).toString())){
                return entry.getKey();
            }
        }
        return 0;
    }

    public int getIngredientID(Map<Integer, String> map){
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            if (Objects.equals(entry.getValue(), Objects.requireNonNull(ingredients.getSelectedValue()))){
                return entry.getKey();
            }
        }
        return 0;
    }

    public void createRecipeGUI(){
        frame = new JFrame();
        frame.setTitle("Create Recipe");
        frame.setResizable(false);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel recipeNameLabel = new JLabel("Enter Recipe Name: ");
        recipeNameLabel.setBounds(10, 50, 150, 20);
        frame.add(recipeNameLabel);

        JTextField recipeNameField = new JTextField();
        recipeNameField.setBounds(130, 50, 150, 20);
        frame.add(recipeNameField);

        createButton = new JButton("Create");
        createButton.setBounds(100,100,100,25);
        createButton.addActionListener(this);
        frame.add(createButton);

        frame.revalidate();
        frame.repaint();
    }

    public void createAddGUI(){
        frame = new JFrame();
        frame.setTitle("Select Quantity");
        frame.setResizable(false);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel quantityLabel = new JLabel("Enter Quantity: ");
        quantityLabel.setBounds(10, 50, 150, 20);
        frame.add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(130, 50, 150, 20);
        frame.add(quantityField);

        addButton = new JButton("Add");
        addButton.setBounds(100,100,100,25);
        addButton.addActionListener(this);
        frame.add(addButton);

        frame.revalidate();
        frame.repaint();
    }

    public void createRemoveGUI(){
        frame = new JFrame();
        frame.setTitle("Select Quantity");
        frame.setResizable(false);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel quantityLabel = new JLabel("Enter Quantity: ");
        quantityLabel.setBounds(10, 50, 150, 20);
        frame.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(130, 50, 150, 20);
        frame.add(quantityField);

        removeButton = new JButton("Remove");
        removeButton.setBounds(100,100,100,25);
        removeButton.addActionListener(this);
        frame.add(removeButton);

        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToRecipeButton) {
            createAddGUI();
        }
        if (e.getSource() == createRecipeButton) {
            createRecipeGUI();
        }
        if (e.getSource() == removeFromRecipeButton){
            createRemoveGUI();
        }
        if (e.getSource() == createButton) {
            frame.dispose();
        }
        if (e.getSource() == addButton) {
            frame.dispose();
            int ingredientID = getIngredientID(ingredientsMap);
            int recipeID = getRecipeID(recipeMap);
            double quantity = Double.parseDouble(quantityField.getText());
            rdb.addIngredientToRecipe(ingredientID,recipeID, quantity);

        }
        if (e.getSource() == removeButton){
            frame.dispose();
        }
        if (e.getSource() == recipeComboBox){
            // Clear the selection in the JList
            recipeIngredients.clearSelection();

            // Get the ID of the selected recipe
            int recipeId = getRecipeID(recipeMap);

            // Get the ingredients for the selected recipe
            recipeIngredientMap = rdb.getRecipeIngredients(recipeId);
            List<String> recipeIngredientList = new ArrayList<>(recipeIngredientMap.values());

            // Update the data in the existing JList
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String ingredient : recipeIngredientList) {
                listModel.addElement(ingredient);
            }
            recipeIngredients.setModel(listModel);
        }
        if (e.getSource() == submitForReviewButton){
            JOptionPane.showMessageDialog(null, "Submitted For Review", "Submitted", JOptionPane.INFORMATION_MESSAGE);

        }
        if (e.getSource() == saveAsDraftButton){
            JOptionPane.showMessageDialog(null, "Saved As Draft", "Saved", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == backButton){
            dispose();
            RecipesMenuGUI rm = new RecipesMenuGUI(user);
        }
    }
}
