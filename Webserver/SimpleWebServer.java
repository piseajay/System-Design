package Webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class SimpleWebServer {

    private final int port;
    private final String webroot;

    public SimpleWebServer(int port, String webroot) {
        this.port = port;
        this.webroot = webroot;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server started on port " + port);
            System.out.println("Webroot: " + webroot);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread thread = new Thread(() -> handleRequest(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private void handleRequest(Socket clientSocket) {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             OutputStream out = clientSocket.getOutputStream()) {

            // Read the request line
            String requestLine = in.readLine();
            if (requestLine == null) return;

            System.out.println(new Date() + ": " + requestLine);

            // Parse the request
            String[] requestParts = requestLine.split(" ");
            String path = requestParts[1];

            // Default to index.html for root path
            if ("/".equals(path)) {
                path = "/index.html";
            }

            // Create full file path
            Path filePath = Path.of(webroot, path.substring(1));

            if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
                // Determine content type
                String contentType = getContentType(path);
                byte[] content = Files.readAllBytes(filePath);

                // Send headers
                String headers = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: " + contentType + "\r\n" +
                        "Content-Length: " + content.length + "\r\n" +
                        "Server: SimpleWebServer\r\n" +
                        "Date: " + new Date() + "\r\n" +
                        "\r\n";

                out.write(headers.getBytes());
                out.write(content);
            } else {
                // Send 404 response
                String response = "HTTP/1.1 404 Not Found\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Length: 9\r\n" +
                        "Server: SimpleWebServer\r\n" +
                        "Date: " + new Date() + "\r\n" +
                        "\r\n" +
                        "Not Found";
                out.write(response.getBytes());
            }

        } catch (IOException e) {
            System.err.println("Error handling request: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }

    private String getContentType(String path) {
        if (path.endsWith(".html")) return "text/html";
        if (path.endsWith(".css")) return "text/css";
        if (path.endsWith(".js")) return "application/javascript";
        if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return "image/jpeg";
        if (path.endsWith(".png")) return "image/png";
        return "text/plain";
    }

    public static void main(String[] args) {
        SimpleWebServer server = new SimpleWebServer(8080, "webroot");
        server.start();
    }
}
