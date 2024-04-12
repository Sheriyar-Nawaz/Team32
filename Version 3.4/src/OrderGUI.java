import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrderGUI extends GUI implements ActionListener {
    private JButton addButton;
    private JButton submitButton;
    private JTextArea orderTextArea;
    private JComboBox<String> CourseComboBox;
    private JTextField tableNumField;
    private List<Course> Coursees;

    public OrderGUI(String user) {
        super(user);
        setLayout(new GridLayout(4, 1));

        // Initialize components
        addButton = new JButton("Start Cooking");
        addButton.addActionListener(this);

        submitButton = new JButton("Completed Cooking");
        submitButton.addActionListener(this);

        orderTextArea = new JTextArea();
        orderTextArea.setEditable(false);

        // Dummy data for Coursees
        Coursees = new ArrayList<>();
        Coursees.add(new Course("Starters", 1));
        Coursees.add(new Course("Mains", 2));
        Coursees.add(new Course("Deserts", 3));

        String[] CourseNames = Coursees.stream().map(Course::getName).toArray(String[]::new);
        CourseComboBox = new JComboBox<>(CourseNames);

        tableNumField = new JTextField();

        // Add components to the frame
        add(new JLabel("Select Course:"));
        add(CourseComboBox);
        add(new JLabel("Table Number:"));
        add(tableNumField);
        add(addButton);
        add(submitButton);
        add(new JScrollPane(orderTextArea));

        revalidate();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
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
        } else if (e.getSource() == submitButton) {
            // Handle submitting the order
            // You can implement this based on your requirements
            JOptionPane.showMessageDialog(null, "Order Completed!");
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

