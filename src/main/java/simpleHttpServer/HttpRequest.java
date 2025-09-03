package simpleHttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private String method;
    private String url;
    private String version;
    private Map<String, String> headers;
    private String body;

    public HttpRequest(Socket clientSocket) throws IOException {
        var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
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
        while (currentHeaderLine.isEmpty()) {
            String[] headerParts = currentHeaderLine.split(":");
            headers.put(headerParts[0], headerParts[1]);
            currentHeaderLine = in.readLine();
        }
        return headers;
    }

    public String getUrl() {
        return url;
    }
}
