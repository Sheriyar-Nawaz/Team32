import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Interface for communication between Kitchen and Management
interface KitchenManagementSenderInterface {
    void sendMenu();
}

public class KitchenManagementSender implements KitchenManagementSenderInterface {
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_d";
    String password = "sE-D4MssL4w";

    Statement statement1 = null;
    PreparedStatement statement2 = null;
    ResultSet resultSet = null;


    @Override
    public void sendMenu() {
        try {
            HashMap<Integer, List<String>> menuDetails = new HashMap<>();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            statement2 = connection.prepareStatement("SELECT m.MenuID, m.Title, d.Name FROM Menus m " +
                                                         "LEFT JOIN  MenuDishes md ON m.MenuID = md.MenuID " +
                                                         "LEFT JOIN Dishes d ON md.DishID = d.DishID " +
                                                         "ORDER BY m.MenuID, d.DishID");
            resultSet = statement2.executeQuery();
            while(resultSet.next()){
                int menuID = resultSet.getInt("MenuID");
                String title = resultSet.getString("Title");
                String dishName = resultSet.getString("Name");

                menuDetails.putIfAbsent(menuID, new ArrayList<>());
                if (dishName != null){
                    menuDetails.get(menuID).add(title + ": " + dishName);
                } else{
                    System.out.println("No Dishes");
                }
            }

            menuDetails.forEach((menuId, dishName) -> {
                System.out.println("Menu ID: " + menuId);
                dishName.forEach(System.out::println);
            });

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


