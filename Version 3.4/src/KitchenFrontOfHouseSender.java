import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * An interface representing the sender in the kitchen-front-of-house communication.
 */
interface KitchenFrontOfHouseSenderInterface {
    /**
     * Retrieves the status of an order from the database.
     *
     * @param orderId The ID of the order.
     * @return A string representing the status of the order.
     */
    String getOrderStatus(int orderId);

    /**
     * Retrieves the list of unavailable dishes from the database.
     *
     * @param unavailableDishes A list to store the unavailable dishes.
     */
    void getUnavailableDishes(List<Dish> unavailableDishes);
}

/**
 * A class representing the sender in the kitchen-front-of-house communication.
 */
public class KitchenFrontOfHouseSender implements KitchenFrontOfHouseSenderInterface {
    private final String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    private final String username = "in2033t32_d";
    private final String password = "sE-D4MssL4w";

    /**
     * Retrieves the status of an order from the database.
     *
     * @param orderId The ID of the order.
     * @return A string representing the status of the order.
     */
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

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Retrieves the list of unavailable dishes from the database.
     *
     * @param unavailableDishes A list to store the unavailable dishes.
     */
    @Override
    public void getUnavailableDishes(List<Dish> unavailableDishes) {

    }
}
