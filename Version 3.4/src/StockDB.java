public class StockDB {
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
    }
    public void getWaste(){
        //Same as getStock but load wasteQuantity
    }
}
