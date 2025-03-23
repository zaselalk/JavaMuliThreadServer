package com.tec.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(3001)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Request Accepts" + socket.getInetAddress());
                new Thread(() -> handleClient(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void handleClient(Socket socket) {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = dataInputStream.readUTF();
                System.out.println(message);
                dataOutputStream.writeUTF(message);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
