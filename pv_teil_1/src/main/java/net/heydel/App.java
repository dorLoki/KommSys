package net.heydel;

import java.io.IOException;

import net.heydel.client.Client;
import net.heydel.model.User;
import net.heydel.server.Server;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // start server
        Server server = Server.getInstance();
        new Thread(server).start();

        // start client 1
        User user1 = User.getUsers().get(0);
        Client client1 = new Client(user1.getLogin(), user1.getPassword());
        new Thread(client1).start();

        // start client 2
        User user2 = User.getUsers().get(1);
        Client client2 = new Client(user2.getLogin(), user2.getPassword());
        new Thread(client2).start();

        // send messages
        newLine();
        out("Client 1 send login message");
        client1.login();
        Thread.sleep(1000);

        newLine();
        out("Client 2 send login message");
        client2.login();
        Thread.sleep(1000);

        newLine();
        out("Client 1 send message to client 2");
        client1.sendMessage("toni;Hey Toni!");
        Thread.sleep(1000);

        newLine();
        out("Client 2 send message to client 1");
        client2.sendMessage("luke;Hey Luke!");
        Thread.sleep(1000);

        newLine();
        out("Client 1 send message to unknown user");
        client1.sendMessage("felix;Hey Ho!");
        Thread.sleep(1000);

        newLine();
        out("Client 1 send message to offline user");
        client1.sendMessage("jan;Hey Jan!");
        Thread.sleep(1000);

        newLine();
        out("Client 3 send login message");
        User user3 = User.getUsers().get(2);
        Client client3 = new Client(user3.getLogin(), user3.getPassword());
        new Thread(client3).start();
        client3.login();
        Thread.sleep(1000);

        newLine();
        out("Client 1 send message to client 3");
        client1.sendMessage("jan;Hey Jan!");
        Thread.sleep(1000);

        // stop server
        server.stop();
        Thread.sleep(1000);
        newLine();
        client1.sendMessage("jan;Hey Jan!");
    }

    private static void out(String string) {
        System.out.println(string);
    }

    private static void newLine() {
        System.out.println("\n");
    }
}