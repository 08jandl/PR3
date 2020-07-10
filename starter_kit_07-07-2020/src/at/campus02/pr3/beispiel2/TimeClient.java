package at.campus02.pr3.beispiel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {

    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader bufferedReader = null;

        try{
            socket = new Socket(InetAddress.getLocalHost(), 1111);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        }
        catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(socket != null){
                    socket.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
