import java.util.Map;
import java.sql.*;
import java.util.List;

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
