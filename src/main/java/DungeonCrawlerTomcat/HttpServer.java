package DungeonCrawlerTomcat;

import DungeonCrawlerTomcat.DamageTakenPackage.DamageTakenServlet;
import DungeonCrawlerTomcat.HealDamagePackage.HealDamageServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class HttpServer {
    public void start() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);

        Tomcat.addServlet(context, "damageTakenServlet", new DamageTakenServlet());
        context.addServletMappingDecoded("/damageTaken", "damageTakenServlet");

        Tomcat.addServlet(context, "healDamageServlet", new HealDamageServlet());
        context.addServletMappingDecoded("/healDamage", "healDamageServlet");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
        tomcat.getServer().await();
    }
}
