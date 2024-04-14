import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeApproveGUI extends GUI implements ActionListener {
    public RecipeApproveGUI(String userType) {
        super(userType);
        add(backButton);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
