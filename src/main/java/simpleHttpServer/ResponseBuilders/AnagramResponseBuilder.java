package simpleHttpServer.ResponseBuilders;

import simpleHttpServer.HttpRequest;
import simpleHttpServer.HttpResponse;

import java.util.List;

public class AnagramResponseBuilder {

    public String createJsonStringAnagram(List<String> body) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"anagrams\":[");
        body.forEach(b -> sb.append("\"").append(b).append("\"").append(","));
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]}");
        return sb.toString();
    }

    public HttpResponse build(HttpRequest request) {
    }
}
