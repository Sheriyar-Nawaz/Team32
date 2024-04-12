import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class Driver {

    public static void main(String[] args) {
        String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
        String username = "in2033t32_a";
        String password = "7VQ_A-ZBz2w";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Dishes");
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
//            statement.executeUpdate(sql1);
//            System.out.println("Insert Complete.");

              /*
              Insert + Update
              */
//            String sql2 = "INSERT into Menus "
//                    + "(MenuID, Title, CreationDate)"
//                    + "values ('2', 'WeekleyMenu2', '2024-04-12')";
//
//             statement.executeUpdate(sql2);
//             System.out.println("Insert Complete.");

//            String sql3 = "UPDATE MenuDishes "
//                    + " set MenuID = 2"
//                    + " where DishID = 3";
//
//            statement.executeUpdate(sql3);
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
