import java.sql.*;
import java.util.List;
import java.util.Map;

// Interface for communication between Kitchen and Front of House
interface KitchenFrontOfHouseSenderInterface {
    String getOrderStatus(int orderNum);
    void getUnavailableDishes(List<Dish> unavailableDishes);
}

public class KitchenFrontOfHouseSender implements KitchenFrontOfHouseSenderInterface{
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_d";
    String password = "sE-D4MssL4w";
    @Override
    public String getOrderStatus(int orderId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = connection.prepareStatement("SELECT Status FROM Orders WHERE OrderID = ?");
            pstmt.setInt(1, orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String status = rs.getString("Status");
                    connection.close();
                    return status;
                } else {
                    connection.close();
                    return ("No order found with order ID: " + orderId);
                }
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void getUnavailableDishes(List<Dish> unavailableDishes) {

    }
}

