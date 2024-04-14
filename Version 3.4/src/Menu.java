import java.util.List;

public class Menu {
    private String menuId;
    private List<Dish> dishes;
    private String MenuName;


    public Menu(String id, String name, List<Dish> dishes){
        this.menuId = id;
        this.dishes = dishes;
        this.MenuName = name;
    }

    public List<Dish> getDishes() {return dishes;}

    public String getMenuId() {
        return menuId;
    }

    public String getMenuName(){return MenuName;}
}
