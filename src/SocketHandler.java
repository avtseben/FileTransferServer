import java.io.*;
import java.net.Socket;

public class SocketHandler implements  Runnable {

    private Socket socket;
    private static int connCount;

    public SocketHandler(Socket socket){ this.socket = socket; }

    public void run(){
        try {   
            InputStream inStream = socket.getInputStream();//Входной поток
            OutputStream outStream = socket.getOutputStream();//Выходной поток
            connCount++;
            System.out.println("User " + connCount + " connected and works in " + Thread.currentThread().getName());
	
	    new CatchFile(inStream).writeByChars();

            System.out.println("User " + connCount + " disconnected in " + Thread.currentThread().getName());
            inStream.close();
            outStream.close();
            socket.close();
            connCount--;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
