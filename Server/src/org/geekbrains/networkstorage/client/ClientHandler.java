package org.geekbrains.networkstorage.client;

import java.net.Socket;

public class ClientHandler {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
}
