import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the graphical user interface for managing orders.
 * Extends GUI class and implements ActionListener interface.
 */
public class OrderGUI extends GUI implements ActionListener {
    private final JButton startCookingButton; // Button for starting cooking
    private final JButton completeCookingButton; // Button for completing cooking
    private JTextArea orderTextArea; // Text area for displaying orders
    private final JComboBox<String> CourseComboBox; // Combo box for selecting course
    private final JTextField tableNumField; // Text field for entering order ID
    private List<Course> Courses; // List to store Course objects

    /**
     * Constructs a new OrderGUI object with the specified user.
     *
     * @param user The logged-in user.
     */
    public OrderGUI(String user) {
        super(user); // Calls the constructor of the superclass with the logged-in user

        // Set properties for back button (logout button)
        add(backButton);
        backButton.addActionListener(this);
        logo.setBounds(270,-50,300,300); // Set position and size of the logo
        add(logo); // Add logo to the GUI

        OrderDB odb = new OrderDB();
        JTable table_1 = odb.getOrders();

        JScrollPane tableScrollPane = new JScrollPane(table_1);
        tableScrollPane.setBounds(175,250,500,100);
        table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(tableScrollPane);

        startCookingButton = new JButton("Start Cooking");
        startCookingButton.addActionListener(this);
        startCookingButton.setBounds(250, 550, 150, 25);
        add(startCookingButton);

        completeCookingButton = new JButton("Completed Cooking");
        completeCookingButton.addActionListener(this);
        completeCookingButton.setBounds(430, 550, 150, 25);
        add(completeCookingButton);

        // Dummy data for Courses
        Courses = new ArrayList<>();
        Courses.add(new Course("Starters", 1));
        Courses.add(new Course("Mains", 2));

        String[] CourseNames = Courses.stream().map(Course::getName).toArray(String[]::new);

        JLabel courseLabel = new JLabel("Select Course:");
        courseLabel.setForeground(Color.white);
        courseLabel.setBounds(300, 400, 150, 25);
        add(courseLabel);

        CourseComboBox = new JComboBox<>(CourseNames);
        CourseComboBox.setBounds(400, 400, 150, 25);
        add(CourseComboBox);

        JLabel tableNumLabel = new JLabel("Order ID:");
        tableNumLabel.setForeground(Color.white);
        tableNumLabel.setBounds(300, 450, 150, 25);
        add(tableNumLabel);

        tableNumField = new JTextField();
        tableNumField.setBounds(400, 450, 150, 25);
        add(tableNumField);

        revalidate();
        repaint();
    }

    /**
     * Invoked when an action occurs, such as clicking on a button.
     *
     * @param e The ActionEvent that occurred.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startCookingButton) {
            OrderDB odb = new OrderDB();
            odb.StartCooking(Integer.parseInt(tableNumField.getText()), (Objects.requireNonNull(CourseComboBox.getSelectedItem()).toString()));
        } else if (e.getSource() == completeCookingButton) {
            OrderDB odb = new OrderDB();
            odb.CompleteCooking(Integer.parseInt(tableNumField.getText()), (Objects.requireNonNull(CourseComboBox.getSelectedItem()).toString()));
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
