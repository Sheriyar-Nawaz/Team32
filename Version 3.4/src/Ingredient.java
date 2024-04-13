public class Ingredient {
    private String ingredientld;
    private String ingredientName;

    public Ingredient(String ingredientld, String ingredientName) {
        this.ingredientld = ingredientld;
        this.ingredientName = ingredientName;
    }

    public String getIngredientld() {
        return ingredientld;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}