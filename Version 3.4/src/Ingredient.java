public class Ingredient {
    private String ingredientld;
    private String ingredientName;
    private int stock;

    public Ingredient(String ingredientld, String ingredientName, int stock) {
        this.ingredientld = ingredientld;
        this.ingredientName = ingredientName;
        this.stock = stock;
    }

    public void updateStock(int quantity){
        this.stock = quantity;
    }

    public int getStock(){
        return stock;
    }

    public String getIngredientld() {
        return ingredientld;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}