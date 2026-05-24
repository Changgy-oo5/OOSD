package client;

import java.io.IOException;
import java.util.ArrayList;

import common.Candidate;
import common.Message;
import ocsf.client.AbstractClient;

public class PollClient extends AbstractClient {

    public PollClient(String host, int port) {
        super(host, port);
    }

    @Override
    protected void handleMessageFromServer(Object msg) {

        Message message = (Message) msg;

        switch (message.getType()) {

            case "LIST":
                System.out.println("Danh sách ứng viên:");
                printList((ArrayList<Candidate>) message.getData());
                printPrompt();
                break;

            case "UPDATE":
                System.out.println("\nCập nhật kết quả:");
                printList((ArrayList<Candidate>) message.getData());
                printPrompt();
                break;

            case "INFO":
                System.out.println("\n" + message.getData());
                break;

            case "END":
                System.out.println("\n" + message.getData());
                System.exit(0);
                break;
        }
    }

    private void printList(ArrayList<Candidate> list) {
        for (Candidate c : list) {
            System.out.println(
                c.getName() + " - Votes: " + c.getVotes()
            );
        }
    }

    private void printPrompt() {
        System.out.print("\nNhập tên ứng viên để vote: ");
    }

    public void sendMessage(Message msg) {
        try {
            sendToServer(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}