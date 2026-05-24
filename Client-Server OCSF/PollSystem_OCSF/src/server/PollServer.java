package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import common.Candidate;
import common.Message;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class PollServer extends AbstractServer {

    private ArrayList<Candidate> candidates = new ArrayList<>();
    private boolean isVotingOpen = true;

    public PollServer(int port) {
        super(port);

        // Danh sách ứng viên
        candidates.add(new Candidate("TianXuNing"));
        candidates.add(new Candidate("Ziyu"));
        candidates.add(new Candidate("ZhanXuan"));
        candidates.add(new Candidate("LiuXuanCheng"));

        // Timer 60 giây
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isVotingOpen = false;

                Candidate winner = candidates.get(0);
                for (Candidate c : candidates) {
                    if (c.getVotes() > winner.getVotes()) {
                        winner = c;
                    }
                }

                sendToAllClients(
                	    new Message("END",
                	        "Hết giờ! Người thắng: "
                	        + winner.getName()
                	        + " với "
                	        + winner.getVotes()
                	        + " phiếu.")
                	);

                	System.out.println("Voting ended.");
            }
        }, 60000);
    }

    @Override
    protected void handleMessageFromClient(Object msg,
                                           ConnectionToClient client) {

        Message message = (Message) msg;

        switch (message.getType()) {

            case "GET_LIST":
                try {
                	client.sendToClient(
                		    new Message("LIST", new ArrayList<>(candidates))
                	);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "VOTE":

                if (!isVotingOpen) {
                    try {
                        client.sendToClient(
                            new Message("INFO", "Đã hết thời gian bầu chọn!")
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }

                String name = (String) message.getData();

                System.out.println("Nhận vote cho: " + name);

                for (Candidate c : candidates) {
                    if (c.getName().equalsIgnoreCase(name)) {
                        c.addVote();
                        System.out.println(c.getName() + " = " + c.getVotes());
                    }
                }

                ArrayList<Candidate> copy = new ArrayList<>();

                for (Candidate c : candidates) {
                    Candidate temp = new Candidate(c.getName());
                    for (int i = 0; i < c.getVotes(); i++) {
                        temp.addVote();
                    }
                    copy.add(temp);
                }

                sendToAllClients(
                        new Message("UPDATE", copy)
                );
                break;
        }
    }
}
