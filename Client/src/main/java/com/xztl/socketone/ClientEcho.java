package main.java.com.xztl.socketone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEcho {
    
    public ClientEcho(String ip, int port) {

        // Necessario per leggere l'input
        Scanner scanner = new Scanner(System.in);

        // Apro una Socket dentro le parentesi per farla chiudere
        // in automatico alla fine del blocco try-catch
        try (Socket socket = new Socket(ip, port);) {
            
            // Leggo una linea dalla console, che poi diventerà il messaggio
            // da inviare al Server
            String message = scanner.nextLine();

            // Necessario per leggere stringhe
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Necessario per scrivere stringhe
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Mando il messaggio al Server
            out.println(message);
            
            // Aspetto la risposta del Server
            String response = in.readLine();
            
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            System.out.println(e);
        }

        scanner.close();
    }

}
