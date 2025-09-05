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
        String contentType = "";
        String[] url = request.getUrl().split("\\?");
        if (url.length == 2) {
            switch (url[0].toLowerCase()) {
                case "/anagram":
                    contentType = "application/json";
                    content = new AnagramResponseBuilder().createJsonStringAnagram(new Anagram().findAnagrams(url[1]));
                    break;

                case "/romannumerals":
                    contentType = "application/json";
                    content = new RomanNumeralsResponseBuilder().createJsonStringAnagram(new RomanNumerals().convertRomanNumerals(Integer.parseInt(url[1])));
                    break;

            }
        } else {
            contentType = "text/hmtl";
            content = "<html><h1>Hello from Server</h1><br><b>Write either /anagram?(word) or /romannumerals?(number)</b><p1</html>";
        }

        return createResponse(content, contentType);
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
