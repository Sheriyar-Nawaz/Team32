import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides methods to interact with the database for dish construction.
 */
public class DishConstructionDB {
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_a";
    String password = "7VQ_A-ZBz2w";

    Statement statement1 = null;
    PreparedStatement statement2 = null;
    ResultSet resultSet = null;

    /**
     * Retrieves a map of dish IDs and names from the database.
     *
     * @return A map containing dish IDs as keys and dish names as values.
     */
    public Map<Integer, String> getDishes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Map<Integer, String> dishes = new HashMap<>();

            // Execute SQL query to fetch dishes
            PreparedStatement pstmt = connection.prepareStatement("SELECT DishID, Name FROM Dishes");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int dishId = resultSet.getInt("DishID");
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

    /**
     * Inserts a recipe into a dish in the database.
     *
     * @param dishID   The ID of the dish.
     * @param recipeID The ID of the recipe to be inserted into the dish.
     */
    public void InsertRecipeToDish(int dishID, int recipeID) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare SQL statement for inserting recipe into dish
            statement2 = connection.prepareStatement("INSERT INTO DishRecipes(DishID, RecipeID) VALUES (?,?)");
            statement2.setInt(1, dishID);
            statement2.setInt(2, recipeID);

            // Execute SQL update
            int affectedRows = statement2.executeUpdate();
            System.out.println("Successfully added, affected rows: " + affectedRows);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Placeholder method for retrieving recipes from the database.
     * Actual implementation is not provided.
     */
    public void getRecipes() {
        // Implementation to be added
    }
}
