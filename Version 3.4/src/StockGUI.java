import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StockGUI extends GUI implements ActionListener {
    private JButton addDeliveryButton;
    private JButton addOrderButton;
    private JButton viewStockButton;
    private JButton viewWasteButton;
    private JTable table_1;



    public StockGUI(String user) {
        super(user);
        logo.setBounds(270,-50,300,300);
        add(logo);





    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
