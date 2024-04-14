import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class OrderDB {
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_a";
    String password = "7VQ_A-ZBz2w";

    Statement statement1 = null;
    PreparedStatement statement2 = null;
    ResultSet resultSet = null;
    public void StartCooking(int orderID, String dishType){
        //Select OrderID from orders table and update string status to for example: "Mains: Cooking"
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            statement2 = connection.prepareStatement("UPDATE Orders SET Status = ? WHERE OrderID = ?");
            String statusUpdate = dishType + ": Cooking";
            statement2.setString(1, statusUpdate);
            statement2.setInt(2, orderID);


            int affectedRows = statement2.executeUpdate();
            System.out.println("Successful, updated status. AffectedRows: " + affectedRows);

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void CompleteCooking(int orderID, String dishType){
        //Select OrderID and update string status to for example: "Starters: Complete"
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            statement2 = connection.prepareStatement("UPDATE Orders SET Status = ? WHERE OrderID = ?");
            String statusUpdate = dishType + ": Completed";
            statement2.setString(1, statusUpdate);
            statement2.setInt(2, orderID);


            int affectedRows = statement2.executeUpdate();
            System.out.println("Successful, updated status. AffectedRows: " + affectedRows);

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}
