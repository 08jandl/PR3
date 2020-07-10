package at.campus02.pr3.beispiel2;

import java.net.Socket;
import java.sql.Time;
import java.util.Date;

public class ThreadHelper implements Runnable{

    private Socket connToClient;
    Date d = new Date();
    Time time = new Time(d.getTime());

    public ThreadHelper(Socket connToClient) {
        this.connToClient = connToClient;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Client Port " + connToClient);
        System.out.println(d.toString() + " " + time.toString());
    }
}
