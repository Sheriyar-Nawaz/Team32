import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class WastemDB {
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_a";
    String password = "7VQ_A-ZBz2w";
    private Connection connection;
    private ResultSet resultSet;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void updateWaste(String ingredientName, int quantity) {
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT IngredientID FROM Ingredients WHERE Name = ?");
            pstmt.setString(1, ingredientName);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int ingredientId = resultSet.getInt("IngredientID");
                PreparedStatement pstmt2 = connection.prepareStatement("UPDATE Stock SET WasteQuantity = WasteQuantity + ? WHERE IngredientID = ?");
                pstmt2.setInt(1, quantity);
                pstmt2.setInt(2, ingredientId);
                pstmt2.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
