import java.util.List;

public class Dish {
    private String dishId;
    private String dishName;
    private List<Recipe> recipes;

    public Dish(String id, String name, List<Recipe> recipes){
        this.dishId = id;
        this.dishName = name;
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public String getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }
}
