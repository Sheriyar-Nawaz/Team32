import java.util.List;

interface KitchenManagementReceiverInterface {
    MenuCompGUI receiveMenu();
    List<Ingredient> receiveIngredientList();
}


public class KitchenManagementReceiver implements KitchenManagementReceiverInterface{


    @Override
    public MenuCompGUI receiveMenu() {
        return null;
    }

    @Override
    public List<Ingredient> receiveIngredientList() {
        return null;
    }
}