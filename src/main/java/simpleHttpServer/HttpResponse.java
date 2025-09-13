package simpleHttpServer;

import java.util.Map;

public class HttpResponse {
    private String responseLine;
    private Map<String,String> headers;
    private String body;

    public HttpResponse(String responseLine, Map<String, String> headers, String body) {
        this.responseLine = responseLine;
        this.headers = headers;
        this.body = body;
    }

    public String getResponseLine() {
        return responseLine;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
