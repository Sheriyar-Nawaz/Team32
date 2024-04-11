import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.HashMap;

public class Login implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    String[] users = {"Line Chef", "Sous Chef", "Head Chef"};
    JComboBox userIDs = new JComboBox(users);
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel logo = new JLabel();
    ImageIcon image = new ImageIcon("Lancasters-logos.jpeg");
    HashMap<String,String> logininfo;
    public Login(HashMap<String,String> logininfo) {
        this.logininfo = logininfo;

        logo.setIcon(image);
        logo.setBounds(425,100,200,200);


        userIDLabel.setBounds(330,300,75,25);
        userIDLabel.setForeground(Color.white);
        userPasswordLabel.setBounds(300,350,75,25);
        userPasswordLabel.setForeground(Color.white);

        userIDs.setBounds(375,300,200,25);
        userIDs.addActionListener(this);
        //userIDs.setSelectedIndex(0);
        userPasswordField.setBounds(375,350,200,25);

        loginButton.setBounds(425,400,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(logo);
        frame.add(userIDs);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.getContentPane().setBackground(new Color(43,51,54));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950,700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton){
            String userID = userIDs.getSelectedItem().toString();
            String password = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(password)){
                    JOptionPane.showMessageDialog(null, "Login Successful", "Success!", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a User", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
