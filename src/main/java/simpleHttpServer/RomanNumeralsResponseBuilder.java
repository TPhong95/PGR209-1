package simpleHttpServer;

public class RomanNumeralsResponseBuilder {

    public String createJsonStringAnagram(String romanNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"romanNumeral\":[");
        sb.append(romanNumber);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]}");
        return sb.toString();
    }
}
