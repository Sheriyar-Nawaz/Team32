import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeReviewGUI extends GUI implements ActionListener {
    private final JButton removeFromRecipeButton;
    private final JButton approveButton;
    public RecipeReviewGUI(String userType) {
        super(userType);
        add(backButton);
        backButton.addActionListener(this);
        logo.setBounds(300,-50,300,300);
        add(logo);

        JLabel recipesLabel = new JLabel("Recipes for Review");
        recipesLabel.setForeground(Color.white);
        recipesLabel.setBounds(50, 300, 200, 25);
        add(recipesLabel);
        JList<String> recipes = new JList<>(new String[]{"recipe 1", "recipe 2", "recipe 3"});
        JScrollPane recipesScrollPane = new JScrollPane(recipes);
        recipesScrollPane.setBounds(50,325,200,300);
        recipes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(recipesScrollPane);

        JLabel recipeLabel = new JLabel("Selected Recipe");
        recipeLabel.setForeground(Color.white);
        recipeLabel.setBounds(650, 300, 100, 25);
        add(recipeLabel);
        JList<String> ingredientList = new JList<>(new String[]{"eggs", "flour", "butter"});
        JScrollPane recipeScrollPane = new JScrollPane(ingredientList);
        recipeScrollPane.setBounds(650,325,200,275);
        recipes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(recipeScrollPane);

        removeFromRecipeButton = new JButton("Remove from Recipe");
        removeFromRecipeButton.setBounds(650,600,200,25);
        removeFromRecipeButton.addActionListener(this);
        add(removeFromRecipeButton);

        approveButton = new JButton("Submit for Approval");
        approveButton.setBounds(350,400,150,75);
        approveButton.addActionListener(this);
        add(approveButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            dispose();
            RecipesMenuGUI rm = new RecipesMenuGUI(user);
        }
    }
}
