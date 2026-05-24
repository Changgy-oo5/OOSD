package LapTrinhSocket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoChatClient {

    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 8;

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = null;

        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected: " + socket);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            for (int i = '0'; i <= '9'; i++) {
                os.write(i);
                int ch = is.read();
                System.out.print((char) ch + " ");
                Thread.sleep(200);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

}