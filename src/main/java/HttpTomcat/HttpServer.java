package HttpTomcat;

import HttpTomcat.AnagramPackage.AnagramServlet;
import HttpTomcat.RomanNumeralsPackage.RomanNumeralsServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class HttpServer {

    public void start(){
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);

        Tomcat.addServlet(context, "anagramServlet", new AnagramServlet());
        context.addServletMappingDecoded("/anagram", "anagramServlet");

        Tomcat.addServlet(context, "romanNumeralsServlet", new RomanNumeralsServlet());
        context.addServletMappingDecoded("/romannumber", "romanNumeralsServlet");

        Tomcat.addServlet(context, "defaultServletUrl", new DefaultServletUrl());
        context.addServletMappingDecoded("/", "defaultServletUrl");


        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
        tomcat.getServer().await();

    }



}
