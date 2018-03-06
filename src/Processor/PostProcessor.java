package Processor;

import DataModel.Response;
import DataModel.ResponseBuilder;
import DataModel.Post;
import com.google.gson.Gson;

public class PostProcessor extends Processor {

    public PostProcessor(String args) {
        super(args);
    }

    @Override
    public String process() {
        ResponseBuilder responseBuilder = new ResponseBuilder();
        // no args
        if(this.args == null){
            responseBuilder.setStatus("OK");
            Post[] allPosts = Post.getAll();
            responseBuilder.setData(allPosts);
        }else{
            // some args, hopefully userid or postid
            String[] argParts = this.args.split("=");
            String argName = argParts[0]; //Finds userid or postid
            int id = Integer.parseInt(argParts[1]);
            if(argName.equals("userid")){
                Post post = Post.getPostByUserId(id);
                // if no user maybe set status to error
                responseBuilder.setStatus("OK");
                responseBuilder.setData(post);
            }
            else if(argName.equals("postid")){
                Post post = Post.getPostByPostId(id);
                // if no user maybe set status to error
                responseBuilder.setStatus("OK");
                responseBuilder.setData(post);
            }
        }

        Gson gson = new Gson();
        Response response = responseBuilder.build();

        return gson.toJson(response);
    }
}
