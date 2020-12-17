package org.geekbrains.networkstorage.server;

import org.geekbrains.networkstorage.client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    private final Properties serverProperties;

    public Server() {
        serverProperties = ServerProperties.getServerProperties();

        start(serverProperties);
    }

    private void start(Properties properties){
        System.out.println(properties.getProperty("server.port"));
        System.out.println(1);
        try (ServerSocket socket = new ServerSocket((int) properties.get("server.network.port"))){
            clientListener(socket);
        } catch (IOException e){
            /* TODO logging */
        }
    }

    private void clientListener(ServerSocket socket){
        while (true){
            try {
                Socket client = socket.accept();
                new ClientHandler(client);
            } catch (IOException e){
                /* TODO logging */
            }
        }
    }
}
