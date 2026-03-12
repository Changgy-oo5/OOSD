package server;

public class ServerConsole {

    public static void main(String[] args) {

        PollServer server = new PollServer(5555);

        try {
            server.listen();
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}