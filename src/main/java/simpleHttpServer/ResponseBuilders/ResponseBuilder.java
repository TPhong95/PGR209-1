package simpleHttpServer.ResponseBuilders;
import simpleHttpServer.HttpRequest;
import simpleHttpServer.HttpResponse;

public interface ResponseBuilder {
    HttpResponse build(HttpRequest request);
}
