package simpleHttpServer;

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
}
