package simpleserver;

public class Response {
    String status = "OK";
    public User[] data;
    int entries = 7;

    public Response(){
    }
    public Response(String status, int entries, User[] data){
        this.status = status;
        this.entries = entries;
        this.data = data;
    }

    public String getStatusString(){
        return this.status;
    }

}
