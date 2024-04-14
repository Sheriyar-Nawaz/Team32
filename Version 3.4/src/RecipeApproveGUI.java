import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeApproveGUI extends GUI implements ActionListener {
    private final JButton removeFromRecipeButton;
    private final JButton approveButton;
    private JFrame frame;
    private JButton removeButton;

    public RecipeApproveGUI(String userType) {
        super(userType);
        add(backButton);
        backButton.addActionListener(this);
        logo.setBounds(300,-50,300,300);
        add(logo);

        JLabel recipesLabel = new JLabel("Recipes for Approval");
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

        approveButton = new JButton("Approve Recipe");
        approveButton.setBounds(350,400,150,75);
        approveButton.addActionListener(this);
        add(approveButton);
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
        if (e.getSource() == backButton){
            dispose();
            RecipesMenuGUI rm = new RecipesMenuGUI(user);
        }
        if (e.getSource() == approveButton){
            JOptionPane.showMessageDialog(null, "Recipe Approved!", "Approved", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == removeFromRecipeButton){
            createRemoveGUI();
        }
        if (e.getSource() == removeButton) {
            frame.dispose();
        }
    }
}
