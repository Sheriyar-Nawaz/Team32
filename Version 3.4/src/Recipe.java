import java.util.List;

public class Recipe {
    private String recipeId;
    private String recipeName;
    private List<Ingredient> ingredients;
    private String instructions;

    public Recipe(String id, String name, List<Ingredient> ingredients, String instructions){
        this.recipeId = id;
        this.recipeName = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public void addIngredients(Ingredient ingredient, int quantity){
        for (int i = 0; i < quantity; i++) {
            ingredients.add(ingredient);
        }
    }

    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
    }

}