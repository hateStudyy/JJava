package org.yumi.mynet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MySimpleServer {
    ArrayList clientOutputStreams;

    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket socket;
        Scanner scanner;
        public ClientHandler(Socket clientSocket) {
            try {
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
                scanner = new Scanner(System.in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while((message = reader.readLine()) != null ||  scanner.hasNextLine()) {
                    System.out.println("read " + message);
//                    String messageTerminal = scanner.nextLine();
//                    System.out.println("write " + messageTerminal);
//                    sendMessage(messageTerminal);
                    tellEveryone(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void go() {
        clientOutputStreams = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(4399);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter  writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();
        while(it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    public void sendMessage(String messageTerminal) {
//        Iterator it = clientOutputStreams.iterator();
//        while(it.hasNext()) {
//            try {
//                PrintWriter writer = (PrintWriter) it.next();
//                writer.println(messageTerminal);
//                writer.flush();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
    public static void main(String[] args) {
        new MySimpleServer().go();
    }
}
