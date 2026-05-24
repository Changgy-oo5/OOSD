package client;

import java.util.Scanner;

import common.Message;

public class ClientConsole {

	public static void main(String[] args) {

	    PollClient client =
	        new PollClient("localhost", 5555);

	    try {
	        client.openConnection();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Scanner sc = new Scanner(System.in);

	    // Gửi yêu cầu lấy danh sách
	    client.sendMessage(
	        new Message("GET_LIST", null)
	    );

	    // Đợi server gửi LIST về
	    try {
	        Thread.sleep(300);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    while (true) {
	        String name = sc.nextLine().trim();

	        if (!name.isEmpty()) {
	            client.sendMessage(new Message("VOTE", name));
	        }
	    }
	}
}