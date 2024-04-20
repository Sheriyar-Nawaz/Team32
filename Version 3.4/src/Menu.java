import java.util.List;

/**
 * The Menu class represents a menu containing a list of dishes.
 */
public class Menu {
    private String menuId;
    private List<Dish> dishes;
    private String menuName;

    /**
     * Constructs a Menu object with the specified ID, name, and list of dishes.
     *
     * @param id     The ID of the menu.
     * @param name   The name of the menu.
     * @param dishes The list of dishes included in the menu.
     */
    public Menu(String id, String name, List<Dish> dishes) {
        this.menuId = id;
        this.dishes = dishes;
        this.menuName = name;
    }

    /**
     * Retrieves the list of dishes in the menu.
     *
     * @return The list of dishes.
     */
    public List<Dish> getDishes() {
        return dishes;
    }

    /**
     * Retrieves the ID of the menu.
     *
     * @return The ID of the menu.
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * Retrieves the name of the menu.
     *
     * @return The name of the menu.
     */
    public String getMenuName() {
        return menuName;
    }
}
