import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeReviewGUI extends GUI implements ActionListener {
    public RecipeReviewGUI(String userType) {
        super(userType);
        add(backButton);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
