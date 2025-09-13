package simpleHttpServer.ResponseBuilders;

import HttpTomcat.RomanNumeralsPackage.RomanNumerals;
import simpleHttpServer.HttpRequest;
import simpleHttpServer.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsResponseBuilder implements ResponseBuilder {

    @Override
    public HttpResponse build(HttpRequest request) {
        var romanNumber = new RomanNumerals().convertRomanNumerals(Integer.parseInt(request.getUrlParam()));
        var responseLine = createResponseLine();
        var body = createJsonString(romanNumber);
        var headers = createResponseHeader(body);
        return new HttpResponse(responseLine, headers, body);
    }

    private Map<String, String> createResponseHeader(String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Content-Length", String.valueOf(body.length()));
        return headers;
    }

    private String createResponseLine() {
        return "HTTP/1.1 200 OK";
    }

    public String createJsonString(String romanNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"romanNumeral\":[");
        sb.append(romanNumber);
        sb.append("]}");
        return sb.toString();
    }
}
