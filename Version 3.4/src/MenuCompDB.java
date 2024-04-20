import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The MenuCompDB class represents a component of the menu database operations.
 * It handles database interactions related to menus.
 */
public class MenuCompDB {
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    private String username = "in2033t32_a";
    private String password = "7VQ_A-ZBz2w";
    private Connection connection;
    private Statement statement1;
    private PreparedStatement statement2;
    private ResultSet resultSet;

    /**
     * Establishes a connection to the database.
     */
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Retrieves a list of dishes that are not included in the specified menu.
     *
     * @param menuID The ID of the menu.
     * @return A list of dishes not included in the menu.
     */
    public List<String> getDishes(int menuID) {
        connect();
        List<String> dishList = new ArrayList<>();
        try {
            statement2 = connection.prepareStatement("SELECT DishID, Name FROM Dishes WHERE DishID NOT IN (SELECT DishID FROM MenuDishes WHERE MenuID = ?)");
            statement2.setInt(1, menuID);
            resultSet = statement2.executeQuery();

            while (resultSet.next()) {
                int dishId = resultSet.getInt("DishID");
                String name = resultSet.getString("Name");
                dishList.add(dishId + ": " + name);
            }
            resultSet.close();
            statement2.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return dishList;
    }

    /**
     * Retrieves details of a selected menu.
     */
    public void getMenu() {
        // Get selected Menu and return details of that Menu
    }

    /**
     * Retrieves all menus that are not approved.
     */
    public void getAllMenus() {
        // Get all Menus that are not approved
    }

    /**
     * Inserts a new menu into the database.
     */
    public void addMenu() {
        // Insert new menu
    }
}
