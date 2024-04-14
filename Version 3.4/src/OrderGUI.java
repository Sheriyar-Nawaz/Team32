import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrderGUI extends GUI implements ActionListener {
    private JButton startCookingButton;
    private JButton completeCookingButton;
    private JTextArea orderTextArea;
    private JComboBox<String> CourseComboBox;
    private JTextField tableNumField;
    private List<Course> Coursees;

    public OrderGUI(String user) {
        super(user);

        add(backButton);
        backButton.addActionListener(this);
        logo.setBounds(270,-50,300,300);
        add(logo);

        startCookingButton = new JButton("Start Cooking");
        startCookingButton.addActionListener(this);
        startCookingButton.setBounds(250, 550, 150, 25);
        add(startCookingButton);

        completeCookingButton = new JButton("Completed Cooking");
        completeCookingButton.addActionListener(this);
        completeCookingButton.setBounds(430, 550, 150, 25);
        add(completeCookingButton);

        // Dummy data for Coursees
        Coursees = new ArrayList<>();
        Coursees.add(new Course("Starters", 1));
        Coursees.add(new Course("Mains", 2));
        Coursees.add(new Course("Deserts", 3));

        String[] CourseNames = Coursees.stream().map(Course::getName).toArray(String[]::new);

        JLabel courseLabel = new JLabel("Select Course:");
        courseLabel.setForeground(Color.white);
        courseLabel.setBounds(300, 400, 150, 25);
        add(courseLabel);

        CourseComboBox = new JComboBox<>(CourseNames);
        CourseComboBox.setBounds(400, 400, 150, 25);
        add(CourseComboBox);

        JLabel tableNumLabel = new JLabel("Table Number:");
        tableNumLabel.setForeground(Color.white);
        tableNumLabel.setBounds(300, 450, 150, 25);
        add(tableNumLabel);

        tableNumField = new JTextField();
        tableNumField.setBounds(400, 450, 150, 25);
        add(tableNumField);

        revalidate();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startCookingButton) {
            int selectedIndex = CourseComboBox.getSelectedIndex();
            Course selectedCourse = Coursees.get(selectedIndex);
            int tableNum;
            try {
                tableNum = Integer.parseInt(tableNumField.getText());
                selectedCourse.setTableNum(tableNum);
                orderTextArea.append(selectedCourse.toString() + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid table number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == completeCookingButton) {
            // Handle submitting the order
            // You can implement this based on your requirements
            JOptionPane.showMessageDialog(null, "Order Completed!");
        }
        if (e.getSource() == backButton){
            dispose();
            MainMenuGUI mm = new MainMenuGUI(user);
        }
    }

    // Dummy Course class for demonstration
    private class Course {
        private String name;
        private int tableNum;

        public Course(String name, int tableNum) {
            this.name = name;
            this.tableNum = tableNum;
        }

        public String getName() {
            return name;
        }

        public int getTableNum() {
            return tableNum;
        }

        public void setTableNum(int tableNum) {
            this.tableNum = tableNum;
        }

        @Override
        public String toString() {
            return "Course: " + name + ", Table: " + tableNum;
        }
    }
}

