import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;



public class StockDB {
    String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    String username = "in2033t32_a";
    String password = "7VQ_A-ZBz2w";

    Statement statement1 = null;
    PreparedStatement statement2 = null;
    ResultSet resultSet = null;
    private JTable table_1 = new JTable();
    private Connection connection;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void updateStock(String ingredientName, int quantity) {
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT IngredientID FROM Ingredients WHERE Name = ?");
            pstmt.setString(1, ingredientName);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int ingredientId = resultSet.getInt("IngredientID");
                PreparedStatement pstmt3 = connection.prepareStatement("UPDATE Ingredients SET Stock = Stock + ? WHERE IngredientID = ?");
                pstmt3.setInt(1, quantity);
                pstmt3.setInt(2, ingredientId);
                pstmt3.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void AddOrder(int dishID, int quantity){
        //Add new OrderID into table
        //Insert dishID and quantity
    }

    public JTable getStock(){
        //Load all records from stock table. Get quantity recieved for every ingredientID
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            statement1 = connection.createStatement();
            resultSet = statement1.executeQuery("SELECT IngredientID, Name, Stock FROM Ingredients");
            table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
            connection.close();
            return table_1;

        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void getWaste() {
        // Same as getStock but load wasteQuantity
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            statement1 = connection.createStatement();
            resultSet = statement1.executeQuery("SELECT IngredientID, Name, WasteQuantity FROM Ingredients");
            table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
