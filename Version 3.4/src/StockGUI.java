import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockGUI extends JFrame {
    private JButton addDeliveryButton;
    private JButton addOrderButton;
    private JButton viewStockButton;
    private JButton viewWasteButton;

    public StockGUI() {
        setTitle("Stock Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        addDeliveryButton = new JButton("Add Delivery");
        addDeliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle add delivery action
                JOptionPane.showMessageDialog(StockGUI.this, "Add Delivery button clicked");
            }
        });
        add(addDeliveryButton);

        addOrderButton = new JButton("Add Order");
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle add order action
                JOptionPane.showMessageDialog(StockGUI.this, "Add Order button clicked");
            }
        });
        add(addOrderButton);

        viewStockButton = new JButton("View Stock");
        viewStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle view stock action
                JOptionPane.showMessageDialog(StockGUI.this, "View Stock button clicked");
            }
        });
        add(viewStockButton);

        viewWasteButton = new JButton("View Waste");
        viewWasteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle view waste action
                JOptionPane.showMessageDialog(StockGUI.this, "View Waste button clicked");
            }
        });
        add(viewWasteButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StockGUI::new);
    }
}
