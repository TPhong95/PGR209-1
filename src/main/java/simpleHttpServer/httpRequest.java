package simpleHttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class httpRequest {

    private String method;
    private String url;
    private String version;
    private Map<String, String> headers;
    private String body;

    public httpRequest(BufferedReader in) throws IOException {
        var requestLine = in.readLine();
        var requestLineParts = requestLine.split(" ");
        this.method = requestLineParts[0];
        this.url = requestLineParts[1];
        this.version = requestLineParts[2];
        this.headers = parseHeaders(in);
        this.body = null;
    }

    private Map<String, String> parseHeaders(BufferedReader in) throws IOException {
        Map<String, String> headers = new HashMap<>();
        String currentHeaderLine = in.readLine();
        while (currentHeaderLine != null) {
            String[] headerParts = currentHeaderLine.split(":");
            headers.put(headerParts[0], headerParts[1]);
            currentHeaderLine = in.readLine();
        }
        return headers;
    }
}
