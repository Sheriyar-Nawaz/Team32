import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        UserPass userPass = new UserPass();
        LoginGUI login = new LoginGUI(userPass.getLogininfo());


//        List<String> ingredients = Arrays.asList("Tomatoes", "Basil", "Olive Oil");
//
//        RecipesDB r = new RecipesDB();
//        r.addQuantity(2, 3, 2);
        /*
        KitchenFrontOfHouseSender k = new KitchenFrontOfHouseSender();
        String x = k.getOrderStatus(1);
        System.out.println(x);
         */

//      DishConstructionDB DCDB = new DishConstructionDB();
//      DCDB.getDishes();
//      DCDB.InsertRecipeToDish(3,2);
//      OrderDB ODB = new OrderDB();
//      ODB.StartCooking(2);
//      ODB.CompleteCooking(2);
//      MainMenuGUI m = new MainMenuGUI(null);
//      MenuGUI m = new MenuGUI(null);
//      KitchenManagementSender KMS = new KitchenManagementSender();
//      KMS.sendMenu();
        MenuCompDB MCDB = new MenuCompDB();
        List<String> availableDishes = MCDB.getDishes(1);
        availableDishes.forEach(System.out::println);
//<<<<<<< HEAD



//>>>>>>> e277b40984dd885437e530a68fd22473157f477d
    }
}
