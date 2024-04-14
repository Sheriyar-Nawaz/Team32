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
    public void StartCooking(int orderID){
        //Select OrderID from orders table and update isCooking
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            statement2 = connection.prepareStatement("UPDATE Orders SET IsCooking = TRUE WHERE OrderID = ? AND IsComplete = FALSE");
            statement2.setInt(1, orderID);

            int affectedRows = statement2.executeUpdate();
            System.out.println("Successful, updated isCooking. AffectedRows: " + affectedRows);

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void CompleteCooking(){
        //Select OrderID and update isComplete to be true and isCooking to be false
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            //TO-DO

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void AddOrder(String tableNumber){
        //Insert new orderid into the table.
        // Update tableNumber of that orderID to tableNumber
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            //TO-DO

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
