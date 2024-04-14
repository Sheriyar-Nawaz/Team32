import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipesDB {
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t32";
    private String username = "in2033t32_a";
    private String password = "7VQ_A-ZBz2w";
    private Connection connection;
    private Statement statement1;
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
    public Map<Integer, String> getReviews() {
        connect();
        Map<Integer, String> recipes = new HashMap<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT RecipeID, Name FROM Recipes WHERE Status = 'SubmittedDraft'");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int recipeId = resultSet.getInt("RecipeID");
                String name = resultSet.getString("Name");
                recipes.put(recipeId, name);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return recipes;
    }
    public Map<Integer, String> getApproves(){
        //select all the recipe ids and names where the status is "Approve" -- this is for recipes awaiting approval not the same as "Approved"
        connect();
        Map<Integer, String> recipes = new HashMap<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT RecipeID, Name FROM Recipes WHERE Status = 'Reviewed'");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int recipeId = resultSet.getInt("RecipeID");
                String name = resultSet.getString("Name");
                recipes.put(recipeId, name);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return recipes;
    }
    public Map<Integer, String> getRecipes() {
        connect();
        Map<Integer, String> recipes = new HashMap<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT RecipeID, Name FROM Recipes");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int recipeId = resultSet.getInt("RecipeID");
                String name = resultSet.getString("Name");
                recipes.put(recipeId, name);
            }
            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Error while fetching recipes: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return recipes;
    }

    public Map<Integer, String> getRecipeIngredients(int recipeId){ //parameter recipe id
        //select ingredients ids and names where the recipe id is same as parameter
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT IngredientID FROM RecipeIngredients WHERE RecipeID = ?");
            pstmt.setInt(1, recipeId);
            resultSet = pstmt.executeQuery();
            List<Integer> ingredientIDs = new ArrayList<>();
            while(resultSet.next()){
                int ID = resultSet.getInt("IngredientID");
                ingredientIDs.add(ID);

            }
            System.out.println(ingredientIDs);
            Map<Integer, String> ingredients = new HashMap<>();
            for(Integer i : ingredientIDs){
                PreparedStatement pstmt2 = connection.prepareStatement("SELECT Name FROM Ingredients WHERE IngredientID = ?");
                pstmt2.setInt(1, i);
                resultSet = pstmt2.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    ingredients.put(i, name);
                }
            }connection.close();
            return ingredients;


        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
      public Map<Integer, String> getIngredients() {
        connect();
        Map<Integer, String> ingredients = new HashMap<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT IngredientID, Name FROM Ingredients");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int ingredientId = resultSet.getInt("IngredientID");
                String name = resultSet.getString("Name");
                ingredients.put(ingredientId, name);
            }
            resultSet.close();
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error while fetching ingredients: " + e.getMessage());
        }
        return ingredients;
    }
    public String getStatus(int recipeId) {
        connect();
        String status = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT Status FROM Recipes WHERE RecipeID = ?");
            pstmt.setInt(1, recipeId);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                status = resultSet.getString("Status");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public void updateStatus(){ //parameters recipeID and String for status
        //update the status of the specified dish id to whatever the parameter is i.e. Review/Approve/Approved
    }
    public void addIngredient(){ //parameters list of strings ingredients and recipe id
        //insert ingredient(s) specified with the specified recipe id -- ensure status is draft, if it's not -- duplicate recipe details with status changed to draft
    }
    public void addQuantity(){ //parameters double quantity, ingredient id and recipe id
        //insert quantity specified for the ingredient with the specified recipe id
    }
    public void addDescription(){ //parameters String description and recipe id
        //insert description to the id specified
    }
    public void removeIngredient(){ //parameters list of strings ingredients and recipe id
        //delete the ingredient(s) specified from the specified recipe id
    }
}
