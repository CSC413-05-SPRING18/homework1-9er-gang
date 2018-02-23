package simpleserver;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Post {


    private  static Map<Integer, Post> useridDict = new HashMap<>();
    private  static Map<Integer, Post> postidDict = new HashMap<Integer, Post>();
    private  static Map<String, Post> dataDict = new HashMap<>();
    private static ArrayList<Post> allUsers = new ArrayList<Post>();

    public void setPostid(int postid) {
        this.postid = postid;
        System.out.println(postid);
    }

    private int postid;

    public void setUserid(int userid) {
        this.userid = userid;
        System.out.println(userid);
    }

    private  int userid;

    public void setData(String data) {
        this.data = data;
        System.out.println(postid);
    }

    private String data;

    public Post(){
        allUsers.add(this);
    }

    public Post(String data, int postid, int userid){
        this.postid = postid;
        this.userid = userid;
        this.data = data;
        postidDict.put(postid, this);
    }

    public static Post getPost(int postid){
        return postidDict.get(postid);
    }

    public void register(){
        postidDict.put(postid, this);


    public User(){
        allUsers.add(this);
    }

    public User(String username, int userid){
        this.username = username;
        this.userid = userid;
        useridDict.put(userid, this);
    }

    public static User getUser(int userid){
        return useridDict.get(userid);
    }

    public void register(){
        useridDict.put(userid, this);
    }

    public static void loadAll(){
        for(int i = 0 ; i < allUsers.size(); i++){
            allUsers.get(i).register();

        }
    }
}
