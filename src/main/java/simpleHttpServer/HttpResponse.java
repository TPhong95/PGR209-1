package simpleHttpServer;

import java.util.Map;

public class HttpResponse {
    private String responseLine;
    private Map<String,String> headers;
    private String body;

    public HttpResponse(Map<String, String> headers, String body) {
        this.responseLine = "HTTP/1.1 200 OK";
        this.headers = headers;
        this.body = body;
    }

    public String getResponseLine() {
        return responseLine;
    }

    public void setResponseLine(String responseLine) {
        this.responseLine = responseLine;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
