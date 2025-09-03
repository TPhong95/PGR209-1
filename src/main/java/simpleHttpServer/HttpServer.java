package simpleHttpServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {


    private final ServerSocket serverSocket;
    private Socket clientSocket;
    private final String crlf = "\r\n";


    public HttpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                var out = new PrintWriter(clientSocket.getOutputStream(), true);
                RequestHandler requestHandler = new RequestHandler(clientSocket);
                HttpResponse response = requestHandler.handleRequest();
                sendResponse(out, response);
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void sendResponse(PrintWriter out, HttpResponse response) throws IOException {
        out.write(response.getResponseLine() + crlf);
        response.getHeaders().forEach((key, value) -> out.write(key + value + crlf));
        out.write(crlf);
        out.write(response.getBody() + crlf);
        out.write(crlf);

    }
}
