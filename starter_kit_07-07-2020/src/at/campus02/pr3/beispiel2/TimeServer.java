package at.campus02.pr3.beispiel2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.*;

public class TimeServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket connToClient = null;
        List<Thread> clients = new ArrayList<>();
        int counter = 0;

        try{
            System.out.println("Starte Server");
            server = new ServerSocket(1111);

            while(true) {
                for (int i = counter; i < 5; i++) {
                    try {
                        connToClient = server.accept();
                        Thread t = new Thread(new ThreadHelper(connToClient));
                        t.start();

                        clients.add(t);
                        counter++;
                        System.out.println(counter);

                    } catch (SocketTimeoutException e) {
                        System.out.println("Exception thrown");
                        break;
                    }
                    for (Thread t : clients) {
                        t.join();
                    }
                }
            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
