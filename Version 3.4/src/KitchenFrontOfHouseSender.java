import java.util.List;
import java.util.Map;

// Interface for communication between Kitchen and Front of House
interface KitchenFrontOfHouseSender {
    void sendOrderStatus(Map<Integer, String> status);
    void sendUnavailableDishes(List<Dish> unavailableDishes);
}


