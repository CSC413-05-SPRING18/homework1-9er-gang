package simpleserver;

public class ResponseBuilder {

    private Response response;
    private User[] data;
    private StatusCode statusCode;

    public enum StatusCode {
        OK,
        ERROR_GENERAL,
    }

    public void setStatus(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public Response build() {
        String statusString;
        switch (this.statusCode) {
            case OK:
                statusString = "OK";
                break;
            default:
                statusString = "ERROR_GENERAL";
        }
        if (data == null){
            data = new User[0];
        }
        return new Response(statusString, data.length, data);
    }

    public static void main(String args[]){
        ResponseBuilder responseBuilder = new ResponseBuilder();
        responseBuilder.setStatus(StatusCode.ERROR_GENERAL);
        Response response = responseBuilder.build(); //passed into json to receive finalized string
        System.out.println(response.getStatusString());
    }
}
