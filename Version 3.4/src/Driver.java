import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class Driver {

    public static void main(String[] args) {
        String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
        String username = "in2033t32_a";
        String password = "7VQ_A-ZBz2w";

        Statement statement1 = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            statement1 = connection.createStatement(); // For Simple Queries (creationStatement)
            statement2 = connection.prepareStatement("SELECT * from Recipes where RecipeID > ? and isApproved = ?"); // Larger Queries (prepareStatement)

            statement2.setInt(1, 1);
            statement2.setInt(2, 1);

            resultSet = statement2.executeQuery();

            while(resultSet.next()){
                int recID = resultSet.getInt("RecipeID");
                String name = resultSet.getString("Name");
                String desc = resultSet.getString("Description");
                int isApproved = resultSet.getInt("isApproved");

                System.out.println(recID + " " + name + " " + desc + " " + isApproved);
            }





              /*
              Small ResultSet Query
               */
//            resultSet = statement1.executeQuery("SELECT * FROM Dishes");
//
//            while(resultSet.next()){
//                System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2) + " " + resultSet.getString(3) + " " + resultSet.getBigDecimal(4));
//            }


              /*
              Insert Example:
              */
//            String sql1 = "INSERT into Recipes "
//                    + "(RecipeID, Name, Description, isApproved)"
//                    + "values ('5', 'Test_1', 'Test_DELETE', '1')";
//
//            statement1.executeUpdate(sql1);
//            System.out.println("Insert Complete.");

              /*
              Insert + Update
              */
//            String sql2 = "INSERT into Menus "
//                    + "(MenuID, Title, CreationDate)"
//                    + "values ('2', 'WeekleyMenu2', '2024-04-12')";
//
//             statement1.executeUpdate(sql2);
//             System.out.println("Insert Complete.");

//            String sql3 = "UPDATE MenuDishes "
//                    + " set MenuID = 2"
//                    + " where DishID = 3";
//
//            statement1.executeUpdate(sql3);
//            System.out.println("Update Complete.");

            /*
            Delete Example:
             */
//            String sql4 = "DELETE from Recipes WHERE RecipeID = 5";
//            int rowsAffected = statement.executeUpdate(sql4);
//
//            System.out.println("Rows Affected: " + rowsAffected);
//            System.out.println("Delete Complete.");




            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
