import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuCompDB {
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    private String username = "in2033t32_a";
    private String password = "7VQ_A-ZBz2w";
    private Connection connection;
    private Statement statement1;
    private PreparedStatement statement2;
    private ResultSet resultSet;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public List<String> getDishes(int menuID) {
        // Get all dishes that are not on the user selected menu
        connect();
        List<String> dishList = new ArrayList<>();
        try {
            statement2 = connection.prepareStatement("SELECT DishID, Name FROM Dishes WHERE DishID NOT IN (SELECT DishID FROM MenuDishes WHERE MenuID = ?)");
            statement2.setInt(1, menuID);
            resultSet = statement2.executeQuery();

            while(resultSet.next()){
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

    public void getMenu(){
        // Get selected Menu and return details of that Menu
    }

    public void getAllMenus(){
        // Get all Menus that are not approved
    }

    public void addMenu(){
        //Insert new menu
    }


}
