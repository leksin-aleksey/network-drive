package org.geekbrains.networkstorage.client;

public class ClientApplication {
    private static final String HOST = "localhost";
    private static final int PORT = 8586;

    public static void main(String[] args) {
        new Client(HOST, PORT);
    }
}
