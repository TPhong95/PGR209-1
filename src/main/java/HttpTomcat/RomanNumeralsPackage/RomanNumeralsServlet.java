package HttpTomcat.RomanNumeralsPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RomanNumeralsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var number = req.getParameter("number");
        var result = new RomanNumerals().convertRomanNumerals(Integer.parseInt(number));
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Roman number for " + number + "</h1>");
        out.println("<h3>"+result+"</h3>");



    }

}
