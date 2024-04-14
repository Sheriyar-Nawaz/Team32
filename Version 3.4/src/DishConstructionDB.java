import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DishConstructionDB {
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_a";
    String password = "7VQ_A-ZBz2w";

    Statement statement1 = null;
    PreparedStatement statement2 = null;
    ResultSet resultSet = null;

    //
    public void getDishes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            statement1 = connection.createStatement();
            resultSet = statement1.executeQuery("SELECT DishID, Name FROM Dishes");

            while(resultSet.next()){
                int dishID = resultSet.getInt("DishID");
                String name = resultSet.getString("Name");
                System.out.println(dishID + " "  + name);
            }


            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

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
            System.out.println("Successful");
            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public void getRecipes(){

    };



}
