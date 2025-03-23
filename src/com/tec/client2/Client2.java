package com.tec.client2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try(Socket sc = new Socket("localhost",3001)) {
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            Scanner scanner = new Scanner(System.in);
            while(true) {
                dos.writeUTF(scanner.nextLine());
                dos.flush();
                String response = dis.readUTF();
                System.out.println(response);

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
