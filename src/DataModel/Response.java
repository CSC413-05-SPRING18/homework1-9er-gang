package DataModel;

public class Response {

  public String status;
  public int entries = 0;
  public IData[] data;

  public Response(String status, int  entries, IData[] data){
    this.status = status;
    this.entries = entries;
    this.data = data;
  }
}
