import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockGUI extends GUI implements ActionListener {

    private JTextField ingredientField;
    private JButton addToStockButton;
    private JButton addDeliveryButton;
    private JTextField quantityField;
    ;
    private JTable table_1 = new JTable();

    public StockGUI(String user) {
        super(user);
        logo.setBounds(270,-50,300,300);
        add(logo);


        add(backButton);
        backButton.addActionListener(this);

        StockDB sdb = new StockDB();
        table_1 = sdb.getStock();

        JScrollPane tableScrollPane = new JScrollPane(table_1);
        tableScrollPane.setBounds(250,175,350,100);
        table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(tableScrollPane);

        JLabel ingredientLabel = new JLabel("Enter Ingredient:");
        ingredientLabel.setForeground(Color.white);
        ingredientLabel.setBounds(300, 300, 150, 25);
        add(ingredientLabel);

        ingredientField = new JTextField();
        ingredientField.setBounds(410, 300, 200, 25);
        add(ingredientField);

        JLabel quantityLabel = new JLabel("Enter quantity:");
        quantityLabel.setForeground(Color.white);
        quantityLabel.setBounds(300, 350, 150, 25);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setForeground(Color.black);
        quantityField.setBounds(410, 350, 150, 25);
        add(quantityField);

        addToStockButton = new JButton("Add to Stock");
        addToStockButton.setBounds(390, 400, 150, 25);
        addToStockButton.addActionListener(this);
        add(addToStockButton);

        addDeliveryButton = new JButton("Add delivery");
        addDeliveryButton.setBounds(390, 440, 150, 25);
        addDeliveryButton.addActionListener(this);
        add(addDeliveryButton);

        revalidate();
        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToStockButton) {
            String selectedIngredient = (String) ingredientField.getText();
            String quantityText = (String) quantityField.getText();
            try{
                int quantity = Integer.parseInt(quantityText); // convert the quantity to an integer
                System.out.println("Selected ingredient added to stock: " + selectedIngredient);
                JOptionPane.showMessageDialog(this, "Added to Stock: " + quantity + " of " + selectedIngredient);
            } catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Invalid quantity entered. Please enter a valid number.");
            }
        }
        if(e.getSource() == addDeliveryButton){
            JOptionPane.showMessageDialog(this, "Added delivery to stock");
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }
}
