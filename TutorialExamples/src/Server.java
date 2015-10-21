import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {

	public static void main(String[] args) {
		int port = 8000;
		BufferedReader in;
		PrintWriter out;
		ServerSocket server;
		Socket socket;

		try {
			server = new ServerSocket(port);
			socket = server.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String text = in.readLine();
				JOptionPane.showMessageDialog(null, "Text recieved from client: " + text);
				out.println("Your message was "+text.length()+" characters long.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
