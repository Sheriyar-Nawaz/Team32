import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    String user;
    JButton backButton = new JButton("Back");
    public GUI(String userType) {
        user = userType;

        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setBounds(0,20,100,15);
        //add(backButton);

        setTitle("Kitchen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(43,51,54));
        setLayout(null);
        setVisible(true);

        revalidate();
        repaint();
    }
}