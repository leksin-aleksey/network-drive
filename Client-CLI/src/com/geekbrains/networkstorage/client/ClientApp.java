package com.geekbrains.networkstorage.client;

public class ClientApp {
    private static final String HOST = "localhost";
    private static final int PORT = 8585;

    public static void main(String[] args) {
        new Client(HOST, PORT);
    }
}
