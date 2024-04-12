import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    String user;
    JButton backButton = new JButton("Back");
    JLabel logo = new JLabel();
    ImageIcon image = new ImageIcon("C:\\IN1007\\Team32\\Version 3.4\\src\\logo.png");
    public GUI(String userType) {
        user = userType;

        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setBounds(0,20,100,15);
        //add(backButton);

        Image imageResized = image.getImage();
        imageResized = imageResized.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        image = new ImageIcon(imageResized);
        logo.setIcon(image);

        setTitle("Lancaster's Kitchen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(900, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(43,51,54));
        setLayout(null);
        setVisible(true);

        revalidate();
        repaint();
    }
}