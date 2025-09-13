package simpleHttpServer.ResponseBuilders;

import simpleHttpServer.HttpRequest;
import simpleHttpServer.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class DefaultResponseBuilder implements ResponseBuilder {


    @Override
    public HttpResponse build(HttpRequest request) {
        var body = "<html><h1>Welcome to the default response</h1><br>" +
                "<h3>Use either /romannumber or /anagram</h3></html>";
        return new HttpResponse(createStatusLine(), createResponseHeader(body), body);
    }

    private Map<String, String> createResponseHeader(String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html");
        headers.put("Content-Length", String.valueOf(body.length()));
        return headers;
    }

    private String createStatusLine() {
        return "HTTP/1.1 200 OK";
    }
}
