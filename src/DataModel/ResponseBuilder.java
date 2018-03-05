package DataModel;

public class ResponseBuilder {
    public String status;
    public IData[] data;

    public void setStatus(String status){
        this.status = status;
    }

    public void setData(IData[] data){
        this.data = data;
    }

    public void setData(IData data){
        this.data = new IData[1];
        this.data[0] = data;
    }

    public Response build(){
        Response response = new Response(status, data.length, data);
        return response;
    }
}
