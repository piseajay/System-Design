import java.io.*;
import java.net.*;

public class SimpleHttpServer {

    public static void main(String[] args) {
        int port = 8080; // Port on which the server will listen

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("HTTP Server started on port " + port);

            while (true) {
                // Wait for a client connection
                Socket clientSocket = serverSocket.accept();

                // Handle the client request in a separate thread
                new Thread(() -> handleRequest(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try (
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                PrintWriter writer = new PrintWriter(output, true)
        ) {
            // Read the HTTP request line
            String requestLine = reader.readLine();
            System.out.println("Request: " + requestLine);

            if (requestLine != null && requestLine.startsWith("GET")) {
                // Extract requested path
                String[] requestParts = requestLine.split(" ");
                String path = requestParts[1];

                // Respond based on the requested path
                if ("/".equals(path)) {
                    sendResponse(writer, 200, "Welcome to the Simple HTTP Server!");
                } else if ("/hello".equals(path)) {
                    sendResponse(writer, 200, "Hello, World!");
                } else {
                    sendResponse(writer, 404, "404 Not Found: The requested resource was not found.");
                }
            } else {
                // Handle unsupported HTTP methods
                sendResponse(writer, 405, "405 Method Not Allowed: Only GET is supported.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sendResponse(PrintWriter writer, int statusCode, String body) {
        String statusText = switch (statusCode) {
            case 200 -> "OK";
            case 404 -> "Not Found";
            case 405 -> "Method Not Allowed";
            default -> "Internal Server Error";
        };

        // Send HTTP response headers
        writer.println("HTTP/1.1 " + statusCode + " " + statusText);
        writer.println("Content-Type: text/plain");
        writer.println("Content-Length: " + body.length());
        writer.println(); // End of headers
        writer.println(body); // Response body
    }
}
