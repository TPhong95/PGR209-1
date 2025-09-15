package DungeonCrawlerTomcat.DamageTakenPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class DamageTakenServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("health") == null) session.setAttribute("health", "100");
        var damageTaken = req.getParameter("damage");
        var result = new DamageTaken().calculateDamage(Integer.parseInt((String) session.getAttribute("health")), Integer.parseInt(damageTaken));
        session.setAttribute("health", (String) result);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1> Your health is now" + result + "</h1>");
        out.println("<h3> You lost" + damageTaken + "</h3>");
    }
}
