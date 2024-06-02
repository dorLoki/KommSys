import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TcpServer2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress addr = InetAddress.getByName("localhost");
		int backlog = 3;
		try (ServerSocket listenSocket = new ServerSocket(6789, backlog, addr)) {
			while (true) {
				System.out.println("Server: Waiting for connections on port " + listenSocket.getLocalPort());
				final Socket connectionSocket = listenSocket.accept();
				Thread t = new Thread() {
					@Override
					public void run() {
						try {
							System.out.println("Accepted: " + connectionSocket.getLocalPort());
							System.out.println("		  " + connectionSocket.getPort());
							
							final String clientSentence;
							final String capitalizedSentence;

							BufferedReader inFromClient = new BufferedReader(//
									new InputStreamReader(connectionSocket.getInputStream()));
							DataOutputStream outToClient = new DataOutputStream(//
									connectionSocket.getOutputStream());
							clientSentence = inFromClient.readLine();
							System.out.println("Received: " + clientSentence);

							if (clientSentence.equals("sleep"))
								Thread.sleep(TimeUnit.SECONDS.toMillis(30));

							capitalizedSentence = clientSentence.toUpperCase() + '\n';
							outToClient.writeBytes(capitalizedSentence);

							if (clientSentence.equals("stop"))
								return;
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
					};
				};
				t.start();
			}
		}
	}
}