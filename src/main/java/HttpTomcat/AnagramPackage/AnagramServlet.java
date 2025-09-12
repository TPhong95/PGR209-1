package HttpTomcat.AnagramPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AnagramServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var word = req.getParameter("word");
        var result = new Anagram().findAnagrams(word);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Anagram for " + word + "</h1>");
        out.println("<ul>");
        result.forEach(w -> out.println("<li>" + w + "</li>"));
        out.println("</ul>");



    }
}
