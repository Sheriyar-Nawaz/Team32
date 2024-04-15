import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WastemGUI extends GUI implements ActionListener {
    //private final JTable table_1;
    private JTextField ingredientComboBox;
    private JButton addToWasteButton;

    public WastemGUI(String user) {
        super(user);
        setTitle("Waste Management");

        logo.setBounds(300,-50,300,300);
        add(logo);

//        WastemDB wastemDB = new WastemDB();
//        table_1 = wastemDB.getWaste();
//
//        JScrollPane tableScrollPane = new JScrollPane(table_1);
//        tableScrollPane.setBounds(250,250,350,100);
//        table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//        add(tableScrollPane);

        JLabel ingredientLabel = new JLabel("Select Ingredient:");
        ingredientLabel.setForeground(Color.white);
        ingredientLabel.setBounds(300, 400, 150, 25);
        add(ingredientLabel);

        add(backButton);
        backButton.addActionListener(this);

        ingredientComboBox = new JTextField();
        ingredientComboBox.setBounds(410, 400, 200, 25);
        add(ingredientComboBox);

        addToWasteButton = new JButton("Add to Waste");
        addToWasteButton.setBounds(390, 550, 150, 25);
        addToWasteButton.addActionListener(this);
        add(addToWasteButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToWasteButton) {
            String selectedIngredient = (String) ingredientComboBox.getText();
            // Here you can add the selected ingredient to waste
            // For now, let's just print it
            System.out.println("Selected ingredient added to waste: " + selectedIngredient);
            JOptionPane.showMessageDialog(this, "Added to Waste: " + selectedIngredient);
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }
}
//iyfkjhg