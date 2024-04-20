import java.sql.*;
import java.sql.Date;
import java.util.*;

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
    private Menu menu;

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
    public Menu getMenu(String title) {
        try {
            connect();
            statement2 = connection.prepareStatement("SELECT MenuID, Title, CreationDate, Status FROM Menus WHERE Title = ?");
            statement2.setString(1, title);
            resultSet = statement2.executeQuery();

            while (resultSet.next()) {
                int menuId = resultSet.getInt("MenuID");
                String name = resultSet.getString("Title");
                Date date = resultSet.getDate("CreationDate");
                String status = resultSet.getString("Status");
                menu = new Menu(menuId, name, date, status);
            }
            resultSet.close();
            statement2.close();
            connection.close();
            return menu;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Retrieves all menus that are not approved.
     */
    public List<Menu> getAllMenus() {
        connect();
        List<Menu> menus = new ArrayList<>();
        try {
            statement2 = connection.prepareStatement("SELECT MenuID, Title, CreationDate, Status FROM Menus WHERE Status != ?");
            statement2.setString(1, "Approved");
            resultSet = statement2.executeQuery();

            while (resultSet.next()) {
                int menuId = resultSet.getInt("MenuID");
                String name = resultSet.getString("Title");
                Date date = resultSet.getDate("CreationDate");
                String status = resultSet.getString("Status");
                menus.add(new Menu(menuId, name, date, status));
            }
            resultSet.close();
            statement2.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return menus;
    }

    /**
     * Inserts a new menu into the database.
     */
    public void addMenu(int id, String name) {
        connect();
        try {
            Calendar calendar = Calendar.getInstance();
            Date creationDate = new Date(calendar.getTime().getTime());

            statement2 = connection.prepareStatement("INSERT INTO Menus (MenuID, Title, CreationDate, Status) VALUES (?, ?, ?, ?)");
            statement2.setInt(1, id);
            statement2.setString(2, name);
            statement2.setDate(3, creationDate);
            statement2.setString(4, "Draft");
            statement2.executeUpdate();
            statement2.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteDishFromMenu(int menuId, int dishId) {
        try {
            connect();
            statement2 = connection.prepareStatement("DELETE FROM MenuDishes WHERE MenuID = ? AND DishID = ?");
            statement2.setInt(1, menuId);
            statement2.setInt(2, dishId);
            statement2.executeUpdate();
            statement2.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteMenu(int menuId) {
        try {
            connect();
            statement2 = connection.prepareStatement("DELETE FROM Menus WHERE MenuID = ?");
            statement2.setInt(1, menuId);
            statement2.executeUpdate();
            statement2.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}