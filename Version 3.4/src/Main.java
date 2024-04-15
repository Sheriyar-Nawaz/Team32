import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        UserPass userPass = new UserPass();
        LoginGUI login = new LoginGUI(userPass.getLogininfo());
    }
}
