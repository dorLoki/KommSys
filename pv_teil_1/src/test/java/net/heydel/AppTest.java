package net.heydel;

import org.junit.Test;

import net.heydel.client.Client;
import net.heydel.model.User;
import net.heydel.server.Server;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testLogin()
    {
        // init server
        Server server = Server.getInstance();
        Thread serverThread = new Thread(server);
        serverThread.start();

        // init client 1
        User user1 = User.getUsers().get(0);
        Client client1 = new Client(user1.getLogin(), user1.getPassword());

        // init client 2
        User user2 = User.getUsers().get(1);
        Client client2 = new Client(user2.getLogin(), user2.getPassword());

        // login
        client1.login();
    }
}
