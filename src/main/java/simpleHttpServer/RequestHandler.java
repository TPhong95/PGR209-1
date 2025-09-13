package simpleHttpServer;

import simpleHttpServer.ResponseBuilders.AnagramResponseBuilder;
import simpleHttpServer.ResponseBuilders.DefaultResponseBuilder;
import simpleHttpServer.ResponseBuilders.RomanNumeralsResponseBuilder;

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
        try {
            response = handleRequest();
            sendResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendResponse(HttpResponse response) {
        out.print(response.getResponseLine()+ crlf);
        response.getHeaders().forEach((key, value) -> out.print(key + ": " + value + crlf));
        out.print(crlf);
        out.print(response.getBody());
        out.flush();
        out.close();
    }

    private HttpResponse handleRequest() throws IOException {
        var request = new HttpRequest(parseRequestLine(), parseHeaders(), null);
        return switch (request.getPath()) {
            case "/anagram" -> new AnagramResponseBuilder().build(request);
            case "/romannumber" -> new RomanNumeralsResponseBuilder().build(request);
            default -> new DefaultResponseBuilder().build(request);
        };
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

}
