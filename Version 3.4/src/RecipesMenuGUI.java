import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class RecipesMenuGUI extends GUI implements ActionListener {
    JButton createButton = new JButton("Create Recipe");
    JButton reviewButton = new JButton("Review Recipes");
    JButton approveButton = new JButton("Approve Recipes");
    public RecipesMenuGUI(String userType) {
        super(userType);
        add(backButton);
        backButton.addActionListener(this);
        logo.setBounds(300,-50,300,300);
        add(logo);

        createButton.setBounds(100, 300, 200, 100);
        createButton.addActionListener(this);
        add(createButton);

        reviewButton.setBounds(350, 300, 200, 100);
        reviewButton.addActionListener(this);
        if (!Objects.equals(user, "Sous Chef")){
            reviewButton.setEnabled(false);
        } add(reviewButton);

        approveButton.setBounds(600, 300, 200, 100);
        approveButton.addActionListener(this);
        if (!Objects.equals(user, "Head Chef")){
            approveButton.setEnabled(false);
        } add(approveButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == createButton){
            dispose();
            RecipeCreateGUI rc = new RecipeCreateGUI(user);
        }
        if (e.getSource() == reviewButton){
            dispose();
            RecipeReviewGUI rr = new RecipeReviewGUI(user);
        }
        if (e.getSource() == approveButton){
            dispose();
            RecipeApproveGUI ra = new RecipeApproveGUI(user);
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }
}
