import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class MenuGUI extends GUI implements ActionListener {
    private JList<String> dishList;
    private JList<String> menu;
    private JComboBox<Object> menuComboBox;
    private JButton addToMenuButton;
    private JButton finalizeMenuButton;
    private JDateChooser dateChooser;
    private List<String> selectedDishes;

    public MenuGUI(String user) {
        super(user);

        add(backButton);
        backButton.addActionListener(this);

        logo.setBounds(270,-50,300,300);
        add(logo);

        //selectedDishes = new ArrayList<>();
        JLabel dishLabel = new JLabel("Available Dishes");
        dishLabel.setForeground(Color.white);
        dishLabel.setBounds(50, 300, 100, 25);
        add(dishLabel);
        dishList = new JList<>(new String[]{"Spaghetti", "Salad", "Pizza"});
        JScrollPane dishScrollPane = new JScrollPane(dishList);
        dishScrollPane.setBounds(50,325,200,275);
        dishList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(dishScrollPane);

        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setForeground(Color.white);
        menuLabel.setBounds(650, 300, 100, 25);
        add(menuLabel);
        menu = new JList<>(new String[]{"Spaghetti", "Salad", "Pizza"});
        JScrollPane menuScrollPane = new JScrollPane(menu);
        menuScrollPane.setBounds(650,325,200,275);
        menu.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;
        add(menuScrollPane);

        JLabel selectMenuLabel = new JLabel("Select Menu");
        selectMenuLabel.setForeground(Color.white);
        selectMenuLabel.setBounds(50, 175, 100, 25);
        add(selectMenuLabel);
        menuComboBox = new JComboBox<>();
        menuComboBox.setBounds(50,200,200,25);
        add(menuComboBox);

        Calendar cld = Calendar.getInstance();
        dateChooser = new JDateChooser(cld.getTime());
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setBounds(100,100,100,25);
        add(dateChooser);

        addToMenuButton = new JButton("Add to Menu");
        addToMenuButton.setBounds(50,600,200,25);
        addToMenuButton.addActionListener(this);
        add(addToMenuButton);

        finalizeMenuButton = new JButton("Finalise Menu");
        finalizeMenuButton.setBounds(350,450,150,75);
        finalizeMenuButton.addActionListener(this);
        if (!Objects.equals(user, "Head Chef")){
            finalizeMenuButton.setEnabled(false);
        }
        add(finalizeMenuButton);
        populateDishes(new String[]{"Spaghetti", "Salad", "Pizza"});

        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToMenuButton) {
            //String selectedDish = (String) scrollPane.getSelectedItem();
           // selectedDishes.add(selectedDish);
            // Here you can add the selected dish to the menu
            // For now, let's just print it
            //System.out.println("Selected dish: " + selectedDish);
            //JOptionPane.showMessageDialog(null, "Dish added to menu: " + selectedDish);
        } if (e.getSource() == finalizeMenuButton) {
            if (!selectedDishes.isEmpty()) {
                // Here you can finalize the menu
                // For now, let's just print a message
                System.out.println("Menu finalized!");
                JOptionPane.showMessageDialog(null, "Menu Finalized!", "Success", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Menu is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }


    // Dummy dish data for demonstration
    public void populateDishes(String[] dishNames) {
       // for (String dishName : dishNames) {
            //dishComboBox.addItem(dishName);
        //}
    }
}

