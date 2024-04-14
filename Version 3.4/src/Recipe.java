import java.util.List;

public class Recipe {
    private int recipeId;
    private String recipeName;

    public Recipe(int id, String name){
        this.recipeId = id;
        this.recipeName = name;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }
}