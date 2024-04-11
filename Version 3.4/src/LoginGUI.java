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
    JLabel logo = new JLabel();
    ImageIcon image = new ImageIcon("Lancasters-logos.jpeg");
    HashMap<String,String> logininfo;

    public LoginGUI(HashMap<String,String> logininfo) {
        super();
        this.logininfo = logininfo;
        setLayout(null); // Use absolute positioning



        // Add user ID label and combo box
        userIDLabel.setForeground(Color.WHITE);
        userIDLabel.setBounds(330,300,75,25);
        add(userIDLabel);
        userIDs.setBounds(375,300,200,25);
        add(userIDs);

        // Add user password label and password field
        userPasswordLabel.setForeground(Color.WHITE);
        userPasswordLabel.setBounds(300,350,75,25);
        add(userPasswordLabel);
        userPasswordField.setBounds(375,350,200,25);
        add(userPasswordField);

        // Add login button
        loginButton.setBounds(425,400,100,25);
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
                    // Successful login - close login window or do something else
                    dispose();
                    // Example: MainMenu mainmenu = new MainMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a User", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
