import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipesMenuGUI extends GUI implements ActionListener {
    JButton createButton = new JButton("Create Recipe");
    JButton reviewButton = new JButton("Review Recipes");
    JButton approveButton = new JButton("Approve Recipes");
    public RecipesMenuGUI(String userType) {
        super(userType);
        add(backButton);
        backButton.addActionListener(this);
        logo.setBounds(270,-50,300,300);
        add(logo);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
