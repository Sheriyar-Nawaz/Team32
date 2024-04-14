//import net.proteanit.sql.DbUtils;

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
    private JTable table_1;
    public void UpdateStock(String ingredientName, int quantity){
        //Load ingredientID from ingredientName
        //Insert that into stock table
        // Set quantityRecieverd to quantity
    }

    public void AddOrder(int dishID, int quantity){
        //Add new OrderID into table
        //Insert dishID and quantity
    }

    public void getStock(){
        //Load all records from stock table. Get quantity recieved for every ingredientID
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            statement1 = connection.createStatement();
            resultSet = statement1.executeQuery("SELECT IngredientID, Name, Stock FROM Ingredients");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
            //table_1.setModel(DbUtils.resultSetToTableModel(resultSet));


            while(resultSet.next()){
                int ID = resultSet.getInt("IngredientID");
                String name = resultSet.getString("Name");
                double stock = resultSet.getDouble("Stock");
                System.out.println(ID + " "  + name + " " + stock);
            }


            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void getWaste(){
        //Same as getStock but load wasteQuantity
    }
}
