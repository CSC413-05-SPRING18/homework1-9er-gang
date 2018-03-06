package Processor;

import DataModel.Response;
import DataModel.ResponseBuilder;
import DataModel.User;
import com.google.gson.Gson;

public class UserProcessor extends Processor {

    public UserProcessor(String args) {
        super(args);
    }

    @Override
    public String process() {
        ResponseBuilder responseBuilder = new ResponseBuilder();
        // no args
        if (this.args == null) {
            responseBuilder.setStatus("OK");
            User[] allUsers = User.getAll();
            responseBuilder.setData(allUsers);
        } else {
            // some args, hopefully userid or username
            String[] argParts = this.args.split("=");
            String argName = argParts[0];
            int userid = Integer.parseInt(argParts[1]);
            User user = User.getUserByUserId(userid);
            // if no user set error to not found
            if (user == null) {
                responseBuilder.setStatus("Could not find userid");
            } else {
                responseBuilder.setStatus("OK");
                responseBuilder.setData(user);
            }
        }

        Gson gson = new Gson();
        Response response = responseBuilder.build();

        return gson.toJson(response);
    }
}
