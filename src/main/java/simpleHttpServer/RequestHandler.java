package simpleHttpServer;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {

    private final Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public HttpResponse handleRequest() throws IOException {
        var request = getRequest(clientSocket);
        String content = "";
        String[] url = request.getUrl().split("\\?");
        if (url.length == 2) {
            switch (url[0].toLowerCase()) {
                case "/anagram":
                    content = String.valueOf(new Anagram().findAnagrams(url[1]));
                    break;

                case "/romannumerals":
                    content = new RomanNumerals().convertRomanNumerals(Integer.parseInt(url[1]));
                    break;

            }
        } else {
            content = "<html><h1>Hello from Server</h1><br><b>Write either /anagram?(word) or /romannumerals?(number)</b><p1</html>";
        }

        return createResponse(content);
    }

    private HttpResponse createResponse(String content) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type: ", "text/html");
        headers.put("Content-Length ", String.valueOf(content.length()));
        return new HttpResponse(headers, content);
    }

    private HttpRequest getRequest(Socket clientSocket) throws IOException {
        return new HttpRequest(clientSocket);
    }
}
