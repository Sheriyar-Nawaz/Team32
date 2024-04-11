import java.util.HashMap;

public class UserPass {
    HashMap<String, String> logininfo = new HashMap<String,String>();

    public UserPass() {
        logininfo.put("Line Chef", "1111");
        logininfo.put("Sous Chef", "2222");
        logininfo.put("Head Chef", "3333");
    }

    public HashMap<String, String> getLogininfo() {
        return logininfo;
    }
}
