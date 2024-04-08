import java.util.HashMap;

public class UserPass {
    HashMap<String, String> logininfo = new HashMap<String,String>();

    public UserPass() {
        logininfo.put("Head Chef", "1111");
        logininfo.put("Sous Chef", "2222");
        logininfo.put("Line Chef", "3333");
    }

    public HashMap<String, String> getLogininfo() {
        return logininfo;
    }
}
