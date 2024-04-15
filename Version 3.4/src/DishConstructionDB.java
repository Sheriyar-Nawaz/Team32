import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class DishConstructionDB {
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_a";
    String password = "7VQ_A-ZBz2w";

    Statement statement1 = null;
    PreparedStatement statement2 = null;
    ResultSet resultSet = null;

    //
    public Map<Integer, String> getDishes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Map<Integer, String> dishes = new HashMap<>();

            PreparedStatement pstmt = connection.prepareStatement("SELECT DishID, Name FROM Dishes");
            ResultSet resultSet = pstmt.executeQuery(); // Add declaration for ResultSet
            while (resultSet.next()) {
                int dishId = resultSet.getInt("DishID"); // Correct column name to "DishID"
                String name = resultSet.getString("Name");
                dishes.put(dishId, name);
            }
            connection.close();
            return dishes;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // adding existing recipe to an existing Dish
    public void InsertRecipeToDish(int dishID, int recipeID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            statement2 = connection.prepareStatement("INSERT INTO DishRecipes(DishID, RecipeID) VALUES (?,?)");
            statement2.setInt(1, dishID);
            statement2.setInt(2, recipeID);

            int affectedRows = statement2.executeUpdate();
            System.out.println("Successfully added, affected rows: " + affectedRows);
            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public void getRecipes(){


    };



}
