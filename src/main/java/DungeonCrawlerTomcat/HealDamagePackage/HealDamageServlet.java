package DungeonCrawlerTomcat.HealDamagePackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class HealDamageServlet extends HttpServlet {

    private final String edges = "<h3>////////////////////////////////////////////////////////////////////////////////////////////////</h3>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("health") == null) session.setAttribute("health", "100");
        var healing = req.getParameter("heal");
        var result = new HealDamage().calculateHealing(Integer.parseInt((String) session.getAttribute("health")), Integer.parseInt(healing));
        session.setAttribute("health", (String) result);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(edges);
        out.println(edges);
        out.println("<br>");
        out.println("<h1> Health: " + result + "</h1>");
        out.println("<h3> You gained " + healing + "</h3>");
        out.println("<a href=\"http://localhost:8080/healDamage?heal=20\" class=\"button-link\">Heal damage</a>");
        out.println("<br>");
        out.println(edges);
        out.println(edges);
    }
}
