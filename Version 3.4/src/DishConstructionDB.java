import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DishConstructionDB {
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_a";
    String password = "7VQ_A-ZBz2w";

    Statement statement1 = null;
    ResultSet resultSet = null;
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


    public void updateDishes(){


    };


    public void getRecipes(){

    };



}
