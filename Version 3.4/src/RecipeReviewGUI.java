import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecipeReviewGUI extends GUI implements ActionListener {
    private final JButton removeFromRecipeButton;
    private final JButton approveButton;
    private final JButton feedbackButton;
    private JFrame frame;
    private JButton removeButton;
    private JButton submitFeedbackButton;

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

        RecipesDB rdb = new RecipesDB();
        Map<Integer, String> recipeMap = rdb.getReviews();
        List<String> recipeList = new ArrayList<>(recipeMap.values());
        JList<String> recipes = new JList<>((recipeList.toArray(new String[0])));
        JScrollPane recipesScrollPane = new JScrollPane(recipes);
        recipesScrollPane.setBounds(50,325,200,300);
        recipes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(recipesScrollPane);

        JLabel recipeLabel = new JLabel("Selected Recipe");
        recipeLabel.setForeground(Color.white);
        recipeLabel.setBounds(650, 300, 100, 25);
        add(recipeLabel);


        Map<Integer, String> ingredientMap = rdb.getRecipeIngredients(4);
        List<String> ingredientList = new ArrayList<>(ingredientMap.values());
        JList<String> recipeIngredients = new JList<>((ingredientList.toArray(new String[0])));
        JScrollPane recipeScrollPane = new JScrollPane(recipeIngredients);
        recipeScrollPane.setBounds(650,325,200,275);
        recipeIngredients.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(recipeScrollPane);

        removeFromRecipeButton = new JButton("Remove from Recipe");
        removeFromRecipeButton.setBounds(650,600,200,25);
        removeFromRecipeButton.addActionListener(this);
        add(removeFromRecipeButton);

        approveButton = new JButton("Submit for Approval");
        approveButton.setBounds(350,400,150,75);
        approveButton.addActionListener(this);
        add(approveButton);

        feedbackButton = new JButton("Submit Feedback");
        feedbackButton.setBounds(350,500,150,75);
        feedbackButton.addActionListener(this);
        add(feedbackButton);
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
    public void createFeedbackGUI(){
        frame = new JFrame();
        frame.setTitle("Feedback");
        frame.setResizable(false);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel feedbackLabel = new JLabel("Enter Feedback: ");
        feedbackLabel.setBounds(10, 0, 150, 20);
        frame.add(feedbackLabel);

        JTextArea feedbackField = new JTextArea();
        feedbackField.setBounds(120, 0, 150, 150);
        feedbackField.setLineWrap(true);
        feedbackField.setWrapStyleWord(true);
        frame.add(feedbackField);

        submitFeedbackButton = new JButton("Submit");
        submitFeedbackButton.setBounds(0,100,100,25);
        submitFeedbackButton.addActionListener(this);
        frame.add(submitFeedbackButton);

        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeFromRecipeButton){
            createRemoveGUI();
        }
        if (e.getSource() == removeButton) {
            frame.dispose();
        }
        if (e.getSource() == feedbackButton){
            createFeedbackGUI();
        }
        if (e.getSource() == submitFeedbackButton) {
            frame.dispose();
        }
        if (e.getSource() == backButton){
            dispose();
            RecipesMenuGUI rm = new RecipesMenuGUI(user);
        }
        if (e.getSource() == approveButton){
            JOptionPane.showMessageDialog(null, "Submitted For Approval!", "Reviewed", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
