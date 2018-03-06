package DataModel;

import java.util.HashMap;
import java.util.Map;

public class Post implements IData {

    private static Map<Integer, Post> postByPostId = new HashMap<>();
    private static Map<Integer, Post> postByUserId = new HashMap<>();
    private static Post[] allPosts;

    //Variable must be case-sensitive to json variables
    private int postid;
    private int userid;
    private String data;

    public void register() {
        Post.postByPostId.put(this.postid, this);
        Post.postByUserId.put(this.userid, this);
    }

    public static Post getPostByUserId(int userid) {
        Post userPost = null;
        userPost = Post.postByUserId.get(userid);
        return userPost;
    }

    public static Post getPostByPostId(int postid) {
        return Post.postByPostId.get(postid);
    }

    public static void setAll(Post[] allPost) {
        Post.allPosts = allPost;
    }

    public static Post[] getAll() {
        return allPosts;
    }
}
