import java.util.List;

public abstract class Order {
    private int orderID;
    private int tableNum;
    private List<Dish> dishes;
    private String allergen_info;
}
