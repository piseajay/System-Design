package Load_Balancer;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class L4LoadBalancer {

    // List of backend servers
    private static final List<InetSocketAddress> BACKENDS = Arrays.asList(
            new InetSocketAddress("127.0.0.1", 8081),
            new InetSocketAddress("127.0.0.1", 8082),
            new InetSocketAddress("127.0.0.1", 8083)
    );

    // Round-robin index
    private static final AtomicInteger index = new AtomicInteger(0);

    // Method to get the next backend server
    private static InetSocketAddress getNextBackend() {
        int currentIndex = index.getAndUpdate(i -> (i + 1) % BACKENDS.size());
        return BACKENDS.get(currentIndex);
    }

    // Method to handle the client connection
    private static void handleClient(Socket clientSocket) {
        InetSocketAddress backend = getNextBackend();

        try (Socket backendSocket = new Socket(backend.getAddress(), backend.getPort())) {
            System.out.println("Forwarding client " + clientSocket.getRemoteSocketAddress()
                    + " to backend " + backend);

            // Start bidirectional relay
            Thread clientToBackend = new Thread(() -> relay(clientSocket, backendSocket));
            Thread backendToClient = new Thread(() -> relay(backendSocket, clientSocket));

            clientToBackend.start();
            backendToClient.start();

            // Wait for threads to finish
            clientToBackend.join();
            backendToClient.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }

    // Relay traffic from source to destination
    private static void relay(Socket source, Socket destination) {
        try (InputStream in = source.getInputStream();
             OutputStream out = destination.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Relay error: " + e.getMessage());
        }
    }

    // Start the load balancer
    public static void main(String[] args) {
        final int LB_PORT = 8080;

        try (ServerSocket serverSocket = new ServerSocket(LB_PORT)) {
            System.out.println("L4 Load Balancer running on port " + LB_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection from " + clientSocket.getRemoteSocketAddress());

                // Handle each client in a separate thread
                new Thread(() -> handleClient(clientSocket)).start();
            }

        } catch (IOException e) {
            System.err.println("Error starting load balancer: " + e.getMessage());
        }
    }
}
