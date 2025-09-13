package simpleHttpServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            HttpServer server = new HttpServer(8080);
            server.start();
        } catch (IOException e) {
            System.out.println("There's a problem");
        }
    }
}