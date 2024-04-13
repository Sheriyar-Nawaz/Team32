import java.util.List;

public class Menu {
    private String menuId;
    private List<Dish> dishes;

    public Menu(String id, String name, List<Dish> dishes){
        this.menuId = id;
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public String getMenuId() {
        return menuId;
    }
}