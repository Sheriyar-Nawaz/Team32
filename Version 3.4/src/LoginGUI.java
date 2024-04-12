import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginGUI extends GUI implements ActionListener {
    JButton loginButton = new JButton("Login");
    String[] users = {"Line Chef", "Sous Chef", "Head Chef"};
    JComboBox<String> userIDs = new JComboBox<>(users);
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User:");
    JLabel userPasswordLabel = new JLabel("Password:");

    HashMap<String,String> logininfo;

    public LoginGUI(HashMap<String,String> logininfo) {
        super(null);
        this.logininfo = logininfo;
        setLayout(null); // Use absolute positioning

        // Add user ID label and combo box
        userIDLabel.setForeground(Color.WHITE);
        userIDLabel.setBounds(305,300,75,25);
        add(userIDLabel);
        userIDs.setBounds(350,300,200,25);
        add(userIDs);

        logo.setBounds(300,0,300,300);
        add(logo);

        // Add user password label and password field
        userPasswordLabel.setForeground(Color.WHITE);
        userPasswordLabel.setBounds(275,350,75,25);
        add(userPasswordLabel);
        userPasswordField.setBounds(350,350,200,25);
        add(userPasswordField);

        loginButton.setBounds(400,400,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        add(loginButton);

        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userID = userIDs.getSelectedItem().toString();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    user = userID;
                    dispose();
                    MainMenuGUI mainmenu = new MainMenuGUI(user);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a User", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
