import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() {
        setTitle("Kitchen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(43,51,54));
        setLayout(null);
        setVisible(true);
    }
}