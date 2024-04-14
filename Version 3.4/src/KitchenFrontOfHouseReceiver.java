import java.util.Map;
import java.sql.*;
import java.util.List;
import java.util.Map;

interface KitchenFrontOfHouseReceiverInterface {
  OrderGUI receiveOrder();
  Map<Integer, Boolean> receiveCourseCompletionStatus();

}

public class KitchenFrontOfHouseReceiver implements KitchenFrontOfHouseReceiverInterface{


  @Override
  public OrderGUI receiveOrder() {
    return null;
  }

  @Override
  public Map<Integer, Boolean> receiveCourseCompletionStatus() {
    return null;
  }
}
