package DataModel;

import java.util.HashMap;
import java.util.Map;

public class User implements IData {

    private static Map<Integer, User> userById = new HashMap<>();
    private static Map<String, User> userByUserName = new HashMap<>();
    private static User[] allUsers;

    private String username;
    private int userid;

    public void register(){
        User.userById.put(this.userid, this);
        User.userByUserName.put(this.username, this);
    }

    public static User getUserByUserId(int userid){
        User user = null;
        user = User.userById.get(userid);
        return user;
    }

    public static User getUserbyUserName(String username){
        return User.userByUserName.get(username);
    }

    public static void setAll(User[] allUsers){
        User.allUsers = allUsers;
    }

    public static User[] getAll(){
        return allUsers;
    }
}
