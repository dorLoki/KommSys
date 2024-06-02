import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClient2 {
	// Mehrere Verbindungen öffnen
	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		try (Socket clientSocket = new Socket("localhost", 6789)) {
			DataOutputStream outToServer = new DataOutputStream(//
					clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(//
					new InputStreamReader(clientSocket.getInputStream()));
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + '\n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
		}
	}
}