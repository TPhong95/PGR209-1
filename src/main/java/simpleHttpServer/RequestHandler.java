package simpleHttpServer;

import simpleHttpServer.ResponseBuilders.AnagramResponseBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements Runnable {

    private final BufferedReader in;
    private final PrintWriter out;
    private final String crlf = "\r\n";


    public RequestHandler(Socket clientSocket) throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        HttpResponse response = null;
        response = handleRequest();
    }

    private HttpResponse handleRequest() throws IOException {
        var request = new HttpRequest(parseRequestLine(), parseHeaders(), null);
        return switch (request.getPath()) {
            case "/anagram" -> new AnagramResponseBuilder().build(request)
        }
    }

    private Map<String, String> parseHeaders() throws IOException {
        Map<String, String> headers = new HashMap<>();
        var line = in.readLine();
        while (!line.isEmpty()) {
            var headerParts = line.split(":");
            headers.put(headerParts[0], headerParts[1]);
            line = in.readLine();
        }
        return headers;
    }

    private String parseRequestLine() throws IOException {
        return in.readLine();
    }

    private HttpResponse createResponse(String content, String contentType) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type: ", contentType);
        headers.put("Content-Length ", String.valueOf(content.length()));
        return new HttpResponse(headers, content);
    }

    private HttpRequest getRequest(Socket clientSocket) throws IOException {
        return new HttpRequest(clientSocket);
    }
}
