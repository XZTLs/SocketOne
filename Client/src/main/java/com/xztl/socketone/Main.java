package com.xztl.socketone;

import main.java.com.xztl.socketone.ClientEcho;

public class Main {
    public static void main(String[] args) {

        // Porta del Server
        final int PORT = 5000;

        System.out.println("Client Started");

        ClientEcho c = new ClientEcho("localhost", PORT);
    }
}