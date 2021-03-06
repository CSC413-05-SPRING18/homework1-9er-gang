package Processor;

public class ProcessorFactory {

  public static Processor getProcessor(String resource) {
    Processor processor = new ErrorProcessor(null);
    String endpoint;
    String queryString = null;
    String endpointParts[] = resource.split("\\?");
    endpoint = endpointParts[0];
    if (endpointParts.length == 2) {
      queryString = endpointParts[1];
    }

    switch (endpoint) {
      case "/user":
        processor = new UserProcessor(queryString);
        break;
      case "/posts":
        processor = new PostProcessor(queryString);
        break;
      default:
        //later add error code?
        processor = new ErrorProcessor(queryString);
        break;
    }
    return processor;
  }
}
